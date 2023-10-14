import java.util.*;
import java.io.*;

public class PalindromString {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (true) {
            String value = scan.nextLine();
            Boolean ans = checkPalindrome(value);
            System.out.println(ans);
        }

    }

    public static Boolean validCharacter(int ascii) {
        if ((ascii >= 48 && ascii <= 57) || (ascii >= 97 && ascii <= 122)) {
            return true;
        }
        return false;
    }

    public static boolean checkPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            // char -> ascii

            int asciiStart = Character.toLowerCase(str.charAt(start));
            int asciiEnd = Character.toLowerCase(str.charAt(end));

            // skiping the invalid characters
            if (!validCharacter(asciiStart)) {
                start++;
            } else if (!validCharacter(asciiEnd)) {
                end--;
            }
            // checking operation
            else {
                if (asciiEnd != asciiStart) {
                    return false;
                }
                start++;
                end--;
            }

        }
        return true;

    }
}