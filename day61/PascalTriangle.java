import java.util.*;

public class PascalTriangle {
    static int[][] ans;

    public static int[][] pascalTriangle(int N) {
        // jagged array
        ans = new int[N][];
        ans[0] = new int[1];
        ans[0][0] = 1;

        // recursiveApproch(N);
        bottomUp(N);
        return ans;
    }

    private static void bottomUp(int n) {
        int[] prev = new int[n];
        prev[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = new int[i + 1];
            // first and last index are set to 1
            ans[i][0] = ans[i][i] = 1;

            // setting the inner index field
            for (int j = 1; j < i; j++) {
                // sum of previous array values
                ans[i][j] = prev[j - 1] + prev[j];
            }
            prev = ans[i];
        }

    }

    private static int[] recursiveApproch(int n) {

        // base case
        if (n == 1) {
            int[] array = new int[] { 1 };
            return array;
        }

        int[] previousArray = recursiveApproch(n - 1);
        int[] currentArray = new int[n];
        ans[n - 1] = new int[n];
        ans[n - 1][0] = currentArray[0] = 1;
        ans[n - 1][n - 1] = currentArray[n - 1] = 1;

        for (int index = 1; index < n; index++) {
            currentArray[index] = previousArray[index - 1] + previousArray[index];
            ans[n - 1][index] = currentArray[index];
        }
        return currentArray;

    }

}
