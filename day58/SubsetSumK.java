import java.util.*;
import java.io.*;

public class SubsetSumK {

    static int[][] map;

    public static boolean subsetSumToK(int n, int k, int arr[]) {
        map = new int[n + 1][k + 1];
        return optimal(k, n, arr);

    }

    private static boolean topToDownOptimal(int n, int k, int[] arr) {

        if (k < 0 | n < 0)
            return false;
        else if (k == 0 | (n == 0 && arr[n] == k))
            return true;

        boolean pick;
        boolean notPick;
        // 1 = > true
        // 2 = > false

        if (map[n][k] != 0) {
            return map[n][k] == 1 ? true : false;
        }
        pick = topToDownOptimal(n - 1, k - arr[n], arr);
        notPick = topToDownOptimal(n - 1, k, arr);
        map[n][k] = (pick | notPick) ? 1 : 2;
        return (pick | notPick);

    }

    static boolean optimal(int K, int N, int[] arr) {

        // dp[i][j] will be true if there is a subset with sum equal to j using first i
        // elements
        boolean[][] dp = new boolean[N + 1][K + 1];

        // Base case: an empty subset can always achieve a sum of 0
        for (int i = 0; i <= N; i++)
            dp[i][0] = true;

        // Build the dp table
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                // If the current element is greater than the target sum 'j', exclude it
                if (arr[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    // Include the current element or exclude it
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
            }
        }

        return dp[N][K];
    }

    static boolean optimalSpace(int K, int N, int[] arr) {

        boolean[] dp = new boolean[K + 1];

        // Base case: an empty subset can always achieve a sum of 0
        dp[0] = true;

        // Build the dp array
        for (int i = 1; i <= N; i++) {
            // Traverse the dp array from right to left
            for (int j = K; j >= arr[i - 1]; j--) {
                // Include the current element or exclude it
                dp[j] = dp[j] || dp[j - arr[i - 1]];
            }
        }

        // The final result is stored in dp[K]
        return dp[K];
        // boolean[] dp = new boolean[k + 1];

        // dp[0] = true;
        // for (int index = 1; index <= n; index++) {
        // for (int target = 1; target <= k; target++) {
        // if (arr[index] > target)
        // dp[target] = dp[target];
        // else
        // dp[target] = dp[target - arr[index]];
        // }
        // }
        // return dp[k];

    }

}
