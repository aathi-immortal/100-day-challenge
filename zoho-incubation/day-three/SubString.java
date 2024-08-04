public class SubString {

    public static void main(String[] args) {
        String str = "i loooove india";
        String subStr = "ove";
        int index = subString(str, subStr);
        System.out.println();
        System.out.println(index);
    }

    private static int subString(String str, String subStr) {

        for (int index = 0; index < str.length() - subStr.length(); index++) {
            int start = index;
            int result = start;
            int subIndex = 0;
            while (subIndex < subStr.length() && str.charAt(start) == subStr.charAt(subIndex)) {
                start++;
                subIndex++;
            }
            if (subIndex == subStr.length()) {
                return result;
            }

        }
        return -1;
    }
}
