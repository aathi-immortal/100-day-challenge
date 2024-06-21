public class ClimbingStairs {
    // static int[] dp;

    public int climbStairs(int n) {
        // return recSol(n);
        // dp = new int[n];
        // return mimozization(n);
        return bottomUp(n);

    }

    // time optimal
    // private int mimozization(int n) {

    // if (n == 2 || n == 1) {
    // return n;
    // }
    // if (dp[n] != 0)
    // return dp[n];
    // dp[n] = mimozization(n - 1) + mimozization(n - 2);
    // return dp[n];
    // }

    // more optimal
    private int bottomUp(int n) {
        int prevPrev = 1;
        int prev = 2;
        int currentStep = 0;
        if (n < 3)
            return n;
        for (int steps = 3; steps <= n; steps++) {
            currentStep = prev + prevPrev;
            prevPrev = prev;
            prev = currentStep;

        }
        return currentStep;
    }

    // rec
    public int recSol(int n) {
        if (n == 2 || n == 1) {
            return n;
        }
        return recSol(n - 1) + recSol(n - 2);
    }

}
