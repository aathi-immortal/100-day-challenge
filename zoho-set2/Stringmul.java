public class Stringmul {

    public static String encode(String s) {

        // traverse the string
        // pick the first char
        // count = 1;
        int count = 0;
        StringBuilder builder = new StringBuilder();
        char currentChar = s.charAt(0);
        for (int index = 0; index < s.length(); index++) {
            char character = s.charAt(index);
            if (currentChar == character) {
                count++;
            } else {
                addCharater(count, builder, currentChar);
                currentChar = character;
                count = 1;
            }
        }
        addCharater(count, builder, currentChar);
        return builder.toString();
    }

    private static void addCharater(int count, StringBuilder builder, char currentChar) {

        builder.append(currentChar);
        builder.append(count);

    }

    public static void main(String[] args) {
        System.out.println();

        String name = encode("aaaaabbbb");
        System.out.println(name);
    }
}
