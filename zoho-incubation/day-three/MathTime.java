public class MathTime {

    public static void main(String[] args) {
        String str = "123+*";
        float data = magicCalculation(str);
    }

    private static float magicCalculation(String str) {

        int result = Integer.parseInt(Character.toString(str.charAt(0)));
        int numberPointer = 1;
        int operatorPointer = getOperatorPointer(str);
        while (operatorPointer < str.length()) {
            result = doOperation(str.charAt(operatorPointer), result,
                    Integer.parseInt(Character.toString(str.charAt(numberPointer))));
            operatorPointer++;
            numberPointer++;
        }
    }

    private static int doOperation(char charAt, int result, int value) {
        switch (charAt) {
            case '+':
                result += value;
                break;
            case '-':
                result -= value;
                break;
            case '*':
                result *= value;
                break;
            case '/':
                result /= value;
                break;
            default:
                break;
        }
        return result;
    }
}

private static int getOperatorPointer(String str) {
    int index = 0;
    while (index < str.length()) {
        if (Character.isDigit(str.charAt(index))) {
            index++;
        }
        return index;

    }
}
