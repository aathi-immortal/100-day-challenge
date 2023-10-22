import java.util.Scanner;

public class ReplaceSpace {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("enter the string:");
        String str = scan.nextLine();
        replaceSpaces(new StringBuilder(str));

    }

    public static StringBuilder replaceSpaces(StringBuilder str) {

        int i = 0;
        StringBuilder ansStr = new StringBuilder();
        while (i < str.length()) {

            String character = str.charAt(i) + "";
            if (character.compareTo(" ") == 0) {

                ansStr.append("@40");
            } else {
                ansStr.append(character);
            }
            i++;
        }
        return ansStr;
    }
}
