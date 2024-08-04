public class PrintMaxString {

    public static void main(String[] args) {
        String str = "Sokka      thanga aathithan";
        printMaxWord(str);
    }

    private static void printMaxWord(String str) {
        int startMax = 0;
        int maxCount = 0;

        for (int index = 0; index < str.length(); index++) {
            int start = index;
            int count = 0;
            while (index < str.length() && str.charAt(index) != ' ') {
                count++;
                index++;
            }
            if (maxCount < count) {
                maxCount = count;
                startMax = start;
            }
        }
        System.out.println();
        printString(str, startMax, maxCount);
    }

    private static void printString(String str, int startMax, int maxCount) {
        for (int index = startMax; index < startMax + maxCount; index++) {
            System.out.print(str.charAt(index));
        }
        System.out.println();
    }

}
