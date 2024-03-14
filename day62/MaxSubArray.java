
import java.util.*;
import java.io.*;

public class Solution {

    public static long maxSubarraySum(int[] arr, int n) {
        return optimalSolution(arr, n);

    }

    private static long optimalSolution(int[] arr, int n) {

        long maxValue;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
            }
            maxValue = Math.max(maxValue, sum);
        }
        return maxValue;
    }
}

// long max = 0;
// int i = 0;
// int sum = 0;
// while (i < arr.length) {

// sum += arr[i];
// if (sum < arr[i]) {
// sum = arr[i];
// }
// if (sum > max) {
// max = (long) sum;

// } else if (sum <= 0) {
// sum = 0;

// }
// i++;

// }
// return max;

// }