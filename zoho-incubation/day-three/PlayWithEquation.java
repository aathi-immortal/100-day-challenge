import java.util.Arrays;
import java.util.Scanner;

class Equation {
    Term[] terms;
    VariableValue[] variableValues;

    Equation(int size) {
        terms = new Term[size];
    }

    public static Equation parseEquation(String equationInString) {

        equationInString.trim();
        String[] termsInPrimitive = splitTerms(equationInString);// {"2x","4y"}

        int count = 0;
        Equation equation = new Equation(termsInPrimitive.length);
        for (String termInPrimitive : termsInPrimitive) {
            equation.terms[count++] = Term.parseTerm(termInPrimitive);
        }
        return equation;
    }
    
    public int evaluate(int[] arr) {// 0 ->x,1->y,2->z
        // traverse the given variable array
        int result = 0;
        for (Term term : terms) {
            result += term.evaluate(arr);
        }
        return result;
    }

    public static String[] splitTerms(String input) {
        String temArray[] = new String[input.length()];
        int index = 0;
        String regex = "([+-]?[^-+]+)";

        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(input.replaceAll(" ", ""));

        while (matcher.find()) {
            temArray[index++] = matcher.group();
        }
        String[] termArray = new String[index];
        int count = 0;
        for (; count < index; count++) {
            termArray[count] = temArray[count];
        }
        return termArray;
    }

    @Override
    public String toString() {
        return "Equation [terms=" + Arrays.toString(terms) + "]";
    }

    public Equation multiply(String string) {
        Equation newTemEquation = new Equation(this.terms.length + string.length());

        Equation equationTwo = Equation.parseEquation(string);
        int count = 0;
        for (Term firstEquationTerm : this.terms) {
            for (Term secondEquationTerm : equationTwo.terms) {
                newTemEquation.terms[count++] = firstEquationTerm.multiply(secondEquationTerm);
            }
        }
        Equation newEquation = new Equation(count);
        for (int index = 0; index < count; index++) {
            newEquation.terms[index] = newTemEquation.terms[index];
        }
        return newEquation;

    }

    public void display() {
        System.out.println(this.toString());
    }

}

class Term {
    int coefficient;
    Variable[] variables;

    Term(int size) {
        variables = new Variable[size];
    }

    public int evaluate(int[] arr) {
        int result = coefficient;
        for (Variable variable : variables) {
            result *= variable.evaluate(arr);
        }
        return result;
    }

    public Term multiply(Term secondEquationTerm) {
        int[] hashMap = new int[26];
        // multiply coff
        int coefficient = this.coefficient * secondEquationTerm.coefficient;
        loadToMap(hashMap, this.variables);
        loadToMap(hashMap, secondEquationTerm.variables);
        Term newTerm = new Term(getHashMapLength(hashMap));
        newTerm.variables = mapToVariablesArray(hashMap);
        newTerm.coefficient = coefficient;
        return newTerm;
    }

    private int getHashMapLength(int[] hashMap) {
        int count = 0;

        for (int index = 0; index < hashMap.length; index++) {
            if (hashMap[index] > 0) {
                count++;
            }
        }
        return count;
    }

    private Variable[] mapToVariablesArray(int[] hashMap) {
        Variable[] variables = new Variable[getHashMapLength(hashMap)];
        int count = 0;
        for (int index = 0; index < hashMap.length; index++) {
            if (hashMap[index] > 0) {
                Variable variable = new Variable();
                variable.name = (char) (index + 65);
                variable.power = hashMap[index];
                variables[count++] = variable;
            }
        }
        return variables;
    }

    private void loadToMap(int[] hashMap, Variable[] variables) {
        for (int index = 0; index < variables.length; index++) {
            hashMap[(int) Character.toUpperCase(variables[index].name) - 'A'] += variables[index].power;
        }
    }

    public static Term parseTerm(String termInString) {
        termInString = termInString.trim();
        StringBuilder coefficientBuilder = new StringBuilder();
        StringBuilder variableBuilder = new StringBuilder();
        int index = 0;

        if (termInString.charAt(index) == '-') {
            coefficientBuilder.append(termInString.charAt(index));
            index++;
        } else if (termInString.charAt(index) == '+') {
            index++;
        }

        boolean foundVariable = false;
        for (; index < termInString.length(); index++) {
            char ch = termInString.charAt(index);
            if (Character.isDigit(ch)) {
                if (foundVariable) {
                    variableBuilder.append(ch);
                } else {
                    coefficientBuilder.append(ch);
                }
            } else if (ch == '^') {
                foundVariable = true;
            } else {
                variableBuilder.append(ch);
                foundVariable = true;
            }
        }

        int coefficient = coefficientBuilder.length() > 0 ? Integer.parseInt(coefficientBuilder.toString()) : 1;
        Variable variable = Variable.parseVariable(variableBuilder.toString());
        Term term = new Term(variableBuilder.length());
        term.coefficient = coefficient;
        term.variables[0] = variable;

        return term;
    }

    @Override
    public String toString() {
        return "Term [coefficient=" + coefficient + ", variables=" + Arrays.toString(variables) + "]";
    }

}

class Variable {
    char name;
    int power;

    public Variable(char name, int power) {
        this.name = name;
        this.power = power;
    }

    public Variable() {

    }

    public static Variable parseInt(char charAt, int power) {
        Variable variable = new Variable();
        variable.name = charAt;
        variable.power = power;
        return variable;
    }

    public static Variable parseVariable(String varString) {
        char name = varString.charAt(0);
        int power = varString.length() > 1 ? Integer.parseInt(varString.substring(1)) : 1;
        return new Variable(name, power);
    }

    public int evaluate(int[] arr) {
        int currentValue = arr[2];
        if (Character.toLowerCase(this.name) == 'x') {
            currentValue = arr[0];
        } else if (Character.toLowerCase(this.name) == 'y') {
            currentValue = arr[1];
        }
        return (int) Math.pow(currentValue, this.power);

    }

    @Override
    public String toString() {
        return "Variable [name=" + name + ", power=" + power + "]";
    }

}

class VariableValue {
    char name;
    int value;
}

public class PlayWithEquation {
    public static void main(String[] args) {
        int arr[] = { 4, 2, 3 };
        System.out.println();
        Equation equation = Equation.parseEquation("4x-5yx+2z");
        equation.display();
        int result = equation.evaluate(arr);

        System.out.println(result);

        // System.out.println(equation.terms[0].coefficient);
        // System.out.println(equation.terms[0].variables[0].name + " " +
        // equation.terms[0].variables[0].power);
    }
}
