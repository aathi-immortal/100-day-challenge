import java.util.ArrayList;

public class MaxSumNonCOn {
    // static int dp[];

    // public static void main(String[] args) {

    // }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // dp = new int[nums.size()];
        // // return recSol(nums, nums.size() - 1);
        // return mimozization(nums, nums.size() - 1);
        return bottomUp(nums);
    }

    // private static int mimozization(ArrayList<Integer> nums, int n) {

    // if (n < 0)
    // return 0;

    // if (dp[n] != 0)
    // return dp[n];
    // // pick currentValue
    // int pick = nums.get(n) + mimozization(nums, n - 2);
    // int notPick = mimozization(nums, n - 1);
    // dp[n] = Math.max(pick, notPick);
    // return dp[n];
    // }

    private static int bottomUp(ArrayList<Integer> nums) {
        int prev = nums.get(0);
        int prevPrev = 0;
        int currentValue = 0;
        if (nums.size() == 1)
            return prev;
        for (int time = 1; time < nums.size(); time++) {
            currentValue = Math.max(prev, nums.get(time) + prevPrev);
            prevPrev = prev;
            prev = currentValue;
        }
        return currentValue;
    }

    private static int recSol(ArrayList<Integer> nums, int n) {
        if (n < 0)
            return 0;

        // pick currentValue
        int pick = nums.get(n) + recSol(nums, n - 2);
        int notPick = recSol(nums, n - 1);
        return Math.max(pick, notPick);

    }

}
