public class DuplicateInString {

    public static String removeConsecutiveDuplicates(String s) {

        String ans = "";
        int start = 0;
        int end = 1;
        while (end < s.length()) {

            Character startCharacter = s.charAt(start);
            Character nexCharacter = s.charAt(end);
            if (startCharacter.compareTo(nexCharacter) == 0) {
                end++;
            } else {
                ans += startCharacter;
                start = end;

            }

        }

        ans += s.charAt(start);
        return ans;
    }

}
