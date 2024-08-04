public class SecondMax {

    public static void main(String[] args) {
        int[] arr = { 10, 12, 24, 9, 6, 9, 12, 34 };
        int second = getSecondMax(arr);
        System.out.println("second max " + second);
    }

    private static int getSecondMax(int[] arr) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int data : arr) {
            if (data > firstMax) {
                int tem = firstMax;
                firstMax = data;
                secondMax = tem;
            } else if (data > secondMax && firstMax != data) {
                secondMax = data;
            }

        }
        return secondMax == Integer.MIN_VALUE ? -1 : secondMax;
    }
}
