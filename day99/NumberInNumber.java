import java.util.Arrays;

public class NumberInNumber {
    public static void main(String[] args) {

        int a = 34992;
        int b = 1123499;
        StringBuilder stringBuilder = new StringBuilder("343424234442");
        System.out.println();
        System.out.println(stringBuilder.length());
        stringBuilder.deleteCharAt(0);

        System.out.println(stringBuilder.length());
        System.out.println(stringBuilder.toString());
        int[] arr = { -1, -2, -3, -4 };
        Arrays.sort(arr);
        for (int data : arr) {
            System.out.println(data);
        }

        // boolean status = isNumnerInNumber(a, b);
        // System.out.println();
        // System.out.println(status);

    }

    private static boolean isNumnerInNumber(int a, int b) {

        StringBuilder stringBuilder = new StringBuilder(String.valueOf(b));
        String aInString = String.valueOf(a);
        // System.out.println();
        // System.out.println(aInString);
        // System.out.println(stringBuilder.toString());
        return stringBuilder.indexOf(aInString) == -1 ? false : true;

    }

}
