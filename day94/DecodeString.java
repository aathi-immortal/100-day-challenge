public class DecodeString {

    static String decodedString(String s) {

        return decoder(s, 0);

    }

    private static String decoder(String s, int index) {
        int time = 0;
        StringBuilder temBuilder = new StringBuilder();
        String returnedString = "";
        while (index < s.length()) {
            char currentCharacter = s.charAt(index);

            // if the current character is alphabet add it to the tempory buffer
            if (isAlphabet(currentCharacter)) {
                temBuilder.append(currentCharacter);
                index++;
                continue;
            }
            // if we see number then it is times
            else if (isNumber(currentCharacter)) {
                time = Integer.parseInt(Character.toString(currentCharacter));
                index++;
                continue;
            }
            // call the next
            else if (currentCharacter == '[') {
                returnedString = decoder(s, index + 1);
            } else {
                return temBuilder.toString();
            }
            // insert the set of string into the stringBuilder n time
            return insertToStringBuilder(returnedString, time, temBuilder);

        }
        return "";
    }

    private static String insertToStringBuilder(String returnedString, int time, StringBuilder temBuilder) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < time; index++) {
            stringBuilder.append(returnedString);
        }
        for (int index = 0; index < temBuilder.length(); index++) {
            stringBuilder.insert(index, temBuilder.charAt(index));
        }
        return stringBuilder.toString();
    }

    private static boolean isNumber(char currentCharacter) {

        int asciiValue = currentCharacter;
        if (asciiValue >= 48 && asciiValue <= 57)
            return true;
        return false;
    }

    private static boolean isAlphabet(char character) {

        int asciiValue = Character.toUpperCase(character);
        if (asciiValue >= 65 && asciiValue <= 90)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("result" + decodedString("3[a3[b]1[ab]]"));
    }
}
