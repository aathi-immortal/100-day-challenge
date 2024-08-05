import java.util.Arrays;

class Equation {
    Term[] terms;
    VariableValue[] variableValueArray;

    Equation(int numberOfTerms) {
        terms = new Term[numberOfTerms];

    }

    public static Equation parseEquation(String equationInString) {
        int count = 0;
        equationInString.trim();
        String[] termsInPrimitive = splitTerms(equationInString);// {"2x","4y"}

        Equation equation = new Equation(termsInPrimitive.length);

        for (String termInPrimitive : termsInPrimitive) {
            equation.terms[count++] = Term.parseTerm(termInPrimitive);

        }
        equation.variableValueArray = equation.convertToVariableValueArray();

        return equation;
    }

    private VariableValue[] convertToVariableValueArray() {
        VariableValue[] temVariableValueArray = new VariableValue[getVariableCount()];
        int index = 0;
        for (Term term : this.terms) {
            for (Variable variable : term.variables) {
                if (isNewVariable(variable, temVariableValueArray)) {
                    temVariableValueArray[index++] = VariableValue.getInstance(variable);
                }
            }
        }
        return temVariableValueArray;
    }

    private static boolean isNewVariable(Variable variable, VariableValue[] temVariableValueArray) {
        for (VariableValue variableValue : temVariableValueArray) {
            if (variableValue != null && variable.name == variableValue.name)
                return false;
        }
        return true;
    }

    private int getVariableCount() {
        int count = 0;
        for (Term term : this.terms) {
            for (Variable variable : term.variables) {
                count++;
            }
        }
        return count;
    }

    public int evaluate(int[] arr) {// 0 ->x,1->y,2->z
        // traverse the given variable array
        loadValueToVariableValueArray(arr);
        int result = 0;
        for (Term term : terms) {

            result += term.evaluate(arr, getVariableValues(term));
        }
        return result;
    }

    private VariableValue[] getVariableValues(Term term) {
        int index = 0;
        VariableValue[] variableValueArray = new VariableValue[term.variables.length];

        for (Variable variable : term.variables) {

            variableValueArray[index++] = getVariableValues(variable);
        }
        return variableValueArray;
    }

    private VariableValue getVariableValues(Variable variable) {
        for (VariableValue variableValue : variableValueArray) {
            if (variable.name == variableValue.name)
                return variableValue;
        }
        return null;
    }

    private void loadValueToVariableValueArray(int[] arr) {
        int index = 0;
        for (int data : arr) {
            this.variableValueArray[index++].value = data;

        }
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
        return "Equation [terms=" + Arrays.toString(terms) + ", variableValueArray="
                + Arrays.toString(variableValueArray)
                + "]";
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
        newEquation.variableValueArray = newEquation.convertToVariableValueArray();
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

    public int evaluate(int[] arr, VariableValue[] variableValueArray) {
        int result = coefficient;
        for (Variable variable : variables) {
            result *= variable.evaluate(variableValueArray);
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

    public int evaluate(VariableValue[] variableValueArray) {
        int currentValue = 0;

        for (VariableValue variableValue : variableValueArray) {
            if (this.name == variableValue.name) {
                currentValue = variableValue.value;

            }
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

    public static VariableValue getInstance(Variable variable) {
        VariableValue variableValue = new VariableValue();
        variableValue.name = variable.name;
        variableValue.value = 0;
        return variableValue;
    }

    @Override
    public String toString() {
        return "VariableValue [name=" + name + ", value=" + value + "]";
    }

}

public class PlayWithEquation {
    public static void main(String[] args) {
        int arr[] = { 4, 2, 3 };
        System.out.println();
        Equation equation = Equation.parseEquation("4x-2y+3xz");
        equation = equation.multiply("2x+3yz");
        // equation.display();

        int result = equation.evaluate(arr);
        System.out.println(equation);
        System.out.println(result);

    }
}
