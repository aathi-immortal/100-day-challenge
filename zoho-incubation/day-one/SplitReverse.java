public class SplitReverse {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int split = 3;
        splitReverser(arr, split);
    }

    public static void splitReverser(int[] arr, int split) {

        for (int start = 0; start < arr.length; start += split) {
            reverse(start, start + split, arr);
        }

    }

    public static void reverse(int start, int end, int[] arr) {
        if (end < arr.length) {

        }
        // for(;start <)
    }
}
