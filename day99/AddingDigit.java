/**
 * AddingDigit
 */
public class AddingDigit {

    public static void main(String[] args) {

        int number = 2875;
        int digit = 4;
        int result = addDigit(number, digit);
        System.out.println();
        System.out.println(result);
    }

    private static int addDigit(int number, int digit) {

        StringBuilder stringBuilder = new StringBuilder(String.valueOf(number));
        StringBuilder solution = new StringBuilder();
        for (int index = 0; index < stringBuilder.length(); index++) {
            int currentDigit = Integer.parseInt(Character.toString(stringBuilder.charAt(index)));
            currentDigit = currentDigit + digit;
            // stringBuilder.setCharAt(index, (char) currentDigit);
            solution.append(currentDigit + "");
        }
        return Integer.parseInt(solution.toString());
    }
}