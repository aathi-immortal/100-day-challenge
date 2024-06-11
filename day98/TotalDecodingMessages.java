public class TotalDecodingMessages {

    static int validWays = 0;

    public int CountWays(String str) {
        validWays = 0;
        countWaysBacktrack(str, 0);
        return validWays;
    }

    private void countWaysBacktrack(String str, int index) {

        // base case
        if (index >= str.length()) {
            validWays = validWays % (1000000000 + 7);
            validWays++;
            return;
        }
        // currentChar in str
        int currentChar = Integer.parseInt(Character.toString(str.charAt(index)));

        // single digit
        countWaysBacktrack(str, index + 1);

        // next digit
        if ((index + 1) < str.length()) {
            // two digit
            int nextChar = Integer.parseInt(Character.toString(str.charAt(index)));
            int asciiValue = currentChar * 10 + nextChar;
            if (isValidAscii(asciiValue)) {
                countWaysBacktrack(str, index + 2);
            }
        }

    }

    private boolean isValidAscii(int asciiValue) {
        if (asciiValue > 0 && asciiValue < 27) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TotalDecodingMessages totalDecodingMessages = new TotalDecodingMessages();
        totalDecodingMessages.CountWays("36671106");
        System.out.println();
        System.out.println(validWays);
    }
}
