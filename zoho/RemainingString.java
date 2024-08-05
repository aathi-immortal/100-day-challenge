public class RemainingString {
    String printString(String S, char ch, int count) {

        int currentCount = 0;
        // if count is zero return s
        if (count == 0)
            return S;
        // traverse the string
        for (int index = 0; index < S.length(); index++) {
            char character = S.charAt(index);
            if (currentCount == count) {
                return S.substring(index);
            }

            else if (character == ch)
                currentCount++;

        }
        return "Empty string";

    }

}
