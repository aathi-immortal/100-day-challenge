class ArrayReversal

{
    public String reverse(String str) {
        int start = 0;
        int end = str.length() - 1;
        // use string builder for memory optimization
        StringBuilder stringBuilder = new StringBuilder(str);
        while (start < end) {
            char startCharacter = stringBuilder.charAt(start);
            char endCharater = stringBuilder.charAt(end);

            // if current value is not a alphabet
            if (!isAlphabet(startCharacter)) {
                // move the start pointer
                start++;
            }
            // if current value is not a alphabet
            else if (!isAlphabet(endCharater)) {
                // move the end pointer
                end--;
            }
            // if both start and end are now in the alphabet swap it
            else {

                stringBuilder.setCharAt(end, startCharacter);
                stringBuilder.setCharAt(start, endCharater);
            }


        }
        return stringBuilder.toString();
    }

    private boolean isAlphabet(char startCharacter) {

        int asciiValue = Character.toUpperCase(startCharacter);
        if (asciiValue >= 65 && asciiValue <= 90)
            return true;
        return false;
    }
}