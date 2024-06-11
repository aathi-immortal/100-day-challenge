import java.util.ArrayList;

public class PossibleWordsFromPhone {

    static ArrayList<String> possibleStrings;

    static ArrayList<String> possibleWords(int a[], int N) {
        possibleStrings = new ArrayList<>();
        ArrayList<Character> temStack = new ArrayList<>();

        backTracking(a, 0, temStack);
        return possibleStrings;
    }

    private static void backTracking(int[] a, int index, ArrayList<Character> temStack) {

        if (index >= a.length) {
            possibleStrings.add(toString(temStack));
            return;
        }
        int currentDigit = a[index];
        String currentDigitSymbols = getDigitSymbols(currentDigit);
        for (int charIndex = 0; charIndex < currentDigitSymbols.length(); charIndex++) {
            char symbol = currentDigitSymbols.charAt(charIndex);
            // add current value
            temStack.add(symbol);

            backTracking(a, index + 1, temStack);

            // remove current value
            temStack.remove(temStack.size() - 1);
        }

    }

    private static String getDigitSymbols(int currentDigit) {
        String[] symbols = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        return symbols[currentDigit - 2];

    }

    private static String toString(ArrayList<Character> temStack) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char character : temStack) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] a = { 2, 3, 4,5 };
        possibleWords(a, 3);
        System.out.println();
        for (String str : possibleStrings) {
            System.out.println(str);
        }
        System.out.println("count :" + possibleStrings.size());
    }
}
