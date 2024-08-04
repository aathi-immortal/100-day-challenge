public class ReverseAdvance {
    public static void main(String[] args) {
        char[] str = { 'h', 'e', 'l', 'l', 'o', '!', ' ', 'h', 'o', 'w', ' ' };
        reverseOnlyAlpha(str);
        printCharacter(str);
    }

    private static void printCharacter(char[] str) {
        System.out.println();
        for (char character : str) {
            System.out.print(character);
        }
    }

    private static void reverseOnlyAlpha(char[] str) {
        int start = 0;
        int end = str.length - 1;
        while (start < end) {
            while (isNotAlpha(str[start])) {
                start++;
                if (start == str.length)
                    break;

            }
            while (isNotAlpha(str[end])) {
                end--;
                if (end == -1)
                    break;
            }
            if (start != str.length && end != -1) {
                swap(start, end, str);
            }
            start++;
            end--;
        }

    }

    private static boolean isNotAlpha(Character character) {
        int ascii = Character.toUpperCase(character);
        if (ascii >= 65 && ascii <= (65 + 26))
            return false;
        return true;

    }

    private static void swap(int start, int end, char[] str) {
        char tem = str[start];
        str[start] = str[end];
        str[end] = tem;
    }

}
