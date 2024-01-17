public class MinSubset {
    static int maxValue;

    public static int minSubsetSumDifference(int[] arr, int n) {
        maxValue = 0;
        int sum = sumOfValues(arr);
        int target = sum / 2;
        topToBottom(arr, n - 1, 0, target);
        System.out.println(maxValue);
        return Math.abs((sum - maxValue) - maxValue);

    }

    private static int topToBottom(int[] arr, int n, int t, int target) {

        if (maxValue < t && t <= target)
            maxValue = t;

        if (n < 0)
            return 0;
        else if (t > target) {
            return -1;
        }

        topToBottom(arr, n - 1, t + arr[n], target);
        topToBottom(arr, n - 1, t, target);
        return 0;

    }

    private static int sumOfValues(int[] arr) {
        int sum = 0;
        for (int data : arr)
            sum += data;
        return sum;
    }

    public static void main(String[] args) {
        int n = 3;
        int arr[] = { 8, 6, 5 };
        int value = minSubsetSumDifference(arr, n);
        System.out.println(value);
    }
}