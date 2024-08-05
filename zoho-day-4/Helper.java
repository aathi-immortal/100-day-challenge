import java.util.Arrays;

class Equation {
    Term[] terms;

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
        StringBuilder variablesBuilder = new StringBuilder();
        StringBuilder powerBuilder = new StringBuilder();
        int index = 0;

        if (termInString.charAt(index) == '-') {
            coefficientBuilder.append(termInString.charAt(index));
            index++;
        } else if (termInString.charAt(index) == '+') {
            index++;
        }

        boolean variableFound = false;
        for (; index < termInString.length(); index++) {
            char ch = termInString.charAt(index);

            if (Character.isDigit(ch)) {
                if (variableFound) {

                    powerBuilder.append(ch);
                } else {

                    coefficientBuilder.append(ch);
                }
            } else if (ch == '^') {

                variableFound = true;
            } else {

                variablesBuilder.append(ch);
                variableFound = true;
            }
        }

        String coefficient = coefficientBuilder.length() > 0 ? coefficientBuilder.toString() : "1";
        String variables = variablesBuilder.toString();

        String power = powerBuilder.length() > 0 ? powerBuilder.toString() : "1";

        Term term = new Term(variables.length());
        term.coefficient = Integer.parseInt(coefficient);

        for (index = 0; index < variables.length(); index++) {
            term.variables[index] = Variable.parseInt(variables.charAt(index), 1);
        }
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

    public static Variable parseInt(char charAt, int power) {
        Variable variable = new Variable();
        variable.name = charAt;
        variable.power = power;
        return variable;
    }

    @Override
    public String toString() {
        return "Variable [name=" + name + ", power=" + power + "]";
    }

}

public class Helper {
    public static void main(String[] args) {
        System.out.println();
        Equation equation = Equation.parseEquation("4x+5xy+2z");
        equation.display();

        System.out.println("after mul");
        equation = equation.multiply("2x-3y");
        equation.display();
        // System.out.println(equation.terms[0].coefficient);
        // System.out.println(equation.terms[0].variables[0].name + " " +
        // equation.terms[0].variables[0].power);
    }
}