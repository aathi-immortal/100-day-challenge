import java.util.Scanner;

public class ReplaceSpace {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("enter the string:");
        String str = scan.nextLine();
        String ans = replaceSpaces(new StringBuilder(str)).toString();
        System.out.println(ans);

    }

    public static StringBuilder replaceSpaces(StringBuilder str) {

        // int i = 0;
        // StringBuilder ansStr = new StringBuilder();
        // while (i < str.length()) {

        // String character = str.charAt(i) + "";
        // if (character.compareTo(" ") == 0) {

        // ansStr.append("@40");
        // } else {
        // ansStr.append(character);
        // }
        // i++;
        // }
        // return ansStr;
        int i = 0;
        System.out.println(str.length());
        while (i < str.length()) {

            String character = str.charAt(i) + "";
            if (character.compareTo(" ") == 0) {
                str.deleteCharAt(i);
                str.insert(i, "@40");
             

            } else {
                i++;
            }
        }
        return str;
    }
}
