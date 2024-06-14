import java.util.Arrays;

public class NearestToZero {
    public static int closestToZero(int arr[], int n) {

        Arrays.sort(arr);
        if (isPositiveArray(arr)) {
            // return sum of first two values
            return arr[0] + arr[1];
        } else if (isNegativeArray(arr)) {
            // return sum of last two values
            return arr[n - 1] + arr[n - 2];
        }
        // both positive and negative
        else {
            // use kadane algo
            return kadanesAlgo(arr);
        }

    }

    // private static int nearByPair(int[] arr) {

    // int result = Integer.MAX_VALUE;
    // for (int index = 0; index < arr.length - 1; index++) {
    // int currentValue = arr[index];
    // int nextValue = arr[index + 1];
    // int sum = currentValue + nextValue;
    // if (Math.abs(result) <= Math.abs(0 + sum)) {
    // result = sum;
    // }
    // }
    // return result;
    // }

    // private static boolean isNegativeValueInArray(int currentValue, int[] arr) {
    // int start = 0;
    // int end = arr.length - 1;
    // while (start <= end) {
    // int mid = (start + end) / 2;
    // if (arr[mid] == -1 * currentValue) {
    // return true;
    // } else if (arr[mid] > -1 * currentValue) {
    // end = mid - 1;
    // } else {
    // start = mid + 1;
    // }
    // }
    // return false;
    // }

    private static int kadanesAlgo(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int result = Integer.MAX_VALUE;
        while (start < end) {
            int sum = arr[start] + arr[end];
            // previous result is greater than current sum swap it
            if (Math.abs(result) > Math.abs(sum))
                result = sum;
            // in past we faces -1 or 1 now we had 1 or -1 so we need positive
            else if (result == -1 * sum)
                result = Math.abs(sum);

            // positive
            if (sum > -1) {
                end--;
                // negative
            } else if (sum < 0) {
                start++;
                // we found sum of two is zero
            } else
                return 0;

        }
        return result;
    }

    private static boolean isNegativeArray(int[] arr) {
        if (arr[0] < 0 && arr[arr.length - 1] < 0)
            return true;
        return false;
    }

    private static boolean isPositiveArray(int[] arr) {
        if (arr[0] > -1 && arr[arr.length - 1] > -1)
            return true;
        return false;
    }

}
