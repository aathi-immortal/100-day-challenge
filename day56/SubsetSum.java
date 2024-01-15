// You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.

// Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.
public class SubsetSum {

    static boolean flag;
    static int[][] map;

    public static boolean subsetSumToK(int n, int k, int arr[]) {

        map = new int[n][2];
        return topToDownOptimal(n - 1, k, arr);

    }

    private static boolean topToDownOptimal(int n, int k, int[] arr) {

        if (n < 0 || k < 0)
            return false;
        else if (k == 0)
            return true;

        boolean pick;
        boolean notPick;
        if (map[n][0] != 0)
            pick = map[n][0] == 1 ? true : false;
        else {
            pick = topToDownOptimal(n - 1, k - arr[n], arr);
            map[n][0] = pick ? 1 : 2;
        }
        if (map[n][1] != 0)
            notPick = map[n][1] == 1 ? true : false;
        else {
            notPick = topToDownOptimal(n - 1, k, arr);
            map[n][1] = notPick ? 1 : 2;
        }

        return (pick | notPick);

    }

    private static int topToDown(int n, int k, int[] arr, int index, int sum) {

        if (sum == k) {
            flag = true;

        }
        for (int i = index + 1; i < n; i++) {

            topToDown(n, k, arr, i, sum + arr[i]);

        }
        return 0;
    }

    public static void main(String[] args) {

        int[] arr = { 4, 3, 2, 1 };
        subsetSumToK(4, 5, arr);
        System.out.println(flag);
    }
}

// import java.util.* ;
// import java.io.*;
// public class Solution {

// static int[] map;

// public static boolean subsetSumToK(int n, int k, int arr[]) {
// // map = new int[n];
// // return topToDownOptimal(n - 1, k, arr);
// boolean dp[][] = new boolean[n][k+1];

// /* target = 0 (from n to 0 it has reached) that means it could be for any idx
// */

// for(int i = 0; i < n; i++)

// dp[i][0] = true;

// /* on idx = 0 target can be met only when k-arr[0]==0. ie: k==arr[0]

// For eg idx has reached 0. remaining target req is 3. So arr[0] should be 3
// for target to become 0

// Hence dp[0][arr[0]=3] is marked true. Saying target is matched. */

// if(arr[0] <= k)

// dp[0][arr[0]] = true;

// /* since 0th col is set and 0th row's correct idx is also set so start from 1
// 1 */

// for(int idx = 1; idx < n; idx++){

// for(int target = 1; target <= k; target++){

// boolean notTake = dp[idx-1][target];

// boolean take = false;

// if(arr[idx] <= target)

// take = dp[idx-1][target-arr[idx]];

// dp[idx][target] = take||notTake;

// }

// }

// return dp[n-1][k];

// }

// }
