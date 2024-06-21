/**
 * FrogJump
 */
public class FrogJump {
    // static int[] dp;

    public static int frogJump(int n, int heights[]) {
        // dp = new int[n];
        // return recSol(n, heights);
        // return mimozization(n, heights);
        return bottomUp(n, heights);
    }

    // private static int mimozization(int n, int[] heights) {

    // // base case
    // if (n == 1)
    // return 0;
    // if (n == 2)
    // return Math.abs(heights[n - 1] - heights[n - 2]);

    // if (dp[n] != 0)
    // return dp[n];

    // // single jump
    // int singleJumpEnergy = Math.abs(heights[n - 1] - heights[n - 2]) + recSol(n -
    // 1, heights);
    // int doubleJumpEnergy = Math.abs(heights[n - 1] - heights[n - 3]) + recSol(n -
    // 2, heights);
    // dp[n] = Math.min(singleJumpEnergy, doubleJumpEnergy);
    // return dp[n];
    // }

    private static int bottomUp(int n, int[] heights) {
        int prev = Math.abs(heights[1] - heights[0]);
        int prevPrev = 0;
        int currentEnergy = 0;
        if (n == 1)
            return 0;
        if (n == 2)
            return prev;
        for (int steps = 3; steps <= n; steps++) {
            int singleJumpEnergy = Math.abs(heights[steps - 1] - heights[steps - 2]) + prev;
            int doubleJumpEnergy = Math.abs(heights[steps - 1] - heights[steps - 3]) + prevPrev;
            currentEnergy = Math.min(singleJumpEnergy, doubleJumpEnergy);
            prevPrev = prev;
            prev = currentEnergy;

        }
        return currentEnergy;
    }

    private static int recSol(int n, int[] heights) {

        // base case
        if (n == 1)
            return 0;
        if (n == 2)
            return Math.abs(heights[n - 1] - heights[n - 2]);

        // single jump
        int singleJumpEnergy = Math.abs(heights[n - 1] - heights[n - 2]) + recSol(n - 1, heights);
        int doubleJumpEnergy = Math.abs(heights[n - 1] - heights[n - 3]) + recSol(n - 2, heights);
        return Math.min(singleJumpEnergy, doubleJumpEnergy);

    }
    
    public static void main(String[] args) {
        int[] ar = { 10, 50, 10 };
        FrogJump.frogJump(3, ar);
    }

}
