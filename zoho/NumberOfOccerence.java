public class NumberOfOccerence {

    int count(int[] arr, int n, int x) {
        int start = startIndex(arr, n, x);
        int end = endIndex(arr, n, x);
        // System.out.println(start + " " + end);
        if (start == -1)
            return 0;
        return (end - start) + 1;
    }

    private int endIndex(int[] arr, int n, int x) {
        int start = 0;
        int end = n - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            int currentValue = arr[mid];
            if (currentValue < x) {
                // move right
                start = mid + 1;
            } else if (currentValue > x) {
                // move left
                end = mid - 1;
            }
            // it must equal to x
            else if (mid == n - 1)
                // base case 2 2 2 2 -> we are in 0 index
                return n - 1;
            else if (currentValue != arr[mid + 1]) {
                // base case 3 2 2 2
                return mid;
            } else {// move left 2 2 2 2
                start = mid + 1;
            }

        }
        return -1;

    }

    private int startIndex(int[] arr, int n, int x) {

        int start = 0;
        int end = n - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            int currentValue = arr[mid];
            if (currentValue < x) {
                // move right
                start = mid + 1;
            } else if (currentValue > x) {
                // move left
                end = mid - 1;
            }
            // it must equal to x
            else if (mid == 0)
                // base case 2 2 2 2 -> we are in 0 index
                return 0;
            else if (currentValue != arr[mid - 1]) {
                // base case 3 2 2 2
                return mid;
            } else {// move left 2 2 2 2
                end = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {

        NumberOfOccerence numberOfOccerence = new NumberOfOccerence();
        int arr[] = { 8, 9, 10, 12, 12, 12 };
        int result = numberOfOccerence.count(arr, 6, 12);
        // System.out.println(result);

    }
}
