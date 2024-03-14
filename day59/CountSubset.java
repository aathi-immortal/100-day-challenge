public class CountSubset {

    static int[][] map;
    private static final int MOD = 1000000007;

    public static int findWays(int num[], int tar) {

        int n = num.length;
        map = new int[n][tar + 1];
        // return topDown(num, tar, n - 1);
        // return mimoziation(num, tar, n - 1);
        return tabulation(num, tar, n);

    }

    private static int countWays(int[] arr, int n, int k) {
        // dp[i][j] represents the number of ways to get the sum j using the first i
        // elements
        int[][] dp = new int[n + 1][k + 1];

        // There is one way to achieve a sum of 0, i.e., by choosing no elements
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Build the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                // Exclude the current element
                dp[i][j] = dp[i - 1][j];

                // Include the current element if it is less than or equal to the target sum
                if (arr[i - 1] <= j) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - arr[i - 1]]) % MOD;
                }
            }
        }

        return dp[n][k] % MOD;
    }

    private static int tabulation(int[] num, int tar, int n) {
        for (int i = 0; i < n; i++)
            map[i][0] = 1;
        for (int index = 1; index <= n; index++) {
            for (int target = 1; target <= tar; target++) {
                int pick = 0;

                if (num[index - 1] <= target)
                    pick = map[index - 1][target - num[index - 1]];
                map[index][target] = pick + map[index - 1][target];

            }
        }
        return map[n][tar];
    }

    private static int mimoziation(int[] num, int k, int n) {

        if (k < 0 || n < 0)
            return 0;
        else if (k == 0 || (n == 0 && num[n] == k)) {
            return 1;
        }
        if (map[n][k] != 0)
            return map[n][k];
        int pick = topDown(num, k - num[n], n - 1);
        int notPick = topDown(num, k, n - 1);
        map[n][k] = (pick + notPick) % (int) (Math.pow(10, 9) + 7);
        return map[n][k];

    }

    private static int topDown(int[] num, int k, int n) {
        if (k < 0 || n < 0)
            return 0;
        else if (k == 0 || (n == 0 && num[n] == k)) {
            return 1;
        }
        int pick = topDown(num, k - num[n], n - 1);
        int notPick = topDown(num, k, n - 1);
        return (pick + notPick) % (int) (Math.pow(10, 9) + 7);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 4, 5 };

        int value = findWays(arr, 5);
        System.out.println(value);
    }
}
