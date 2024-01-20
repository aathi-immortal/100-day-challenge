import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class SaleMan {
    int weight;
    int value;
    float coastPerWeight;

    SaleMan(int weight, int value, float coastPerWeight) {

        this.weight = weight;
        this.value = value;
        this.coastPerWeight = coastPerWeight;
    }

}

public class KnapSack {
    static int map[][];

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        map = new int[n][maxWeight + 1];
        // return topDown(weight, value, n - 1, maxWeight);
        // return bottomUp(weight, value, n, maxWeight);
        // using single row time compleity => O(n * maxWeight)
        // space complexity => O(maxWeight)
        return bottomUpSpaceOptimized(weight, value, n, maxWeight);
    }

    private static int bottomUpSpaceOptimized(int[] weight, int[] value, int n, int maxWeight) {
        int[] map = new int[maxWeight + 1];
        int[] current = new int[maxWeight + 1];
        for (int i = weight[0]; i <= maxWeight; i++) {
            map[i] = value[0];
        }

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= maxWeight; target++) {
                int pick = Integer.MIN_VALUE;
                if (weight[index] <= target)
                    pick = value[index] + map[target - weight[index]];
                int notPick = map[target];
                current[target] = Math.max(pick, notPick);
            }
            map = current;
            current = new int[maxWeight + 1];
        }
        return map[maxWeight];

    }

    private static int bottomUp(int[] weight, int[] value, int n, int maxWeight) {
        int[][] map = new int[n][maxWeight + 1];
        for (int i = weight[0]; i <= maxWeight; i++) {
            map[0][i] = value[0];
        }

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= maxWeight; target++) {
                int pick = Integer.MIN_VALUE;
                if (weight[index] <= target)
                    pick = value[index] + map[index - 1][target - weight[index]];
                int notPick = map[index - 1][target];
                map[index][target] = Math.max(pick, notPick);
            }
        }
        return map[n - 1][maxWeight];
    }

    private static int topDown(int[] weight, int[] value, int n, int maxWeight) {

        if (maxWeight < 0 || n < 0)
            return 0;
        else if ((n == 0 && weight[n] <= maxWeight)) {
            return value[n];
        } else if (map[n][maxWeight] != 0)
            return map[n][maxWeight];

        int pick = Integer.MIN_VALUE;
        if (weight[n] <= maxWeight)
            pick = value[n] + topDown(weight, value, n - 1, maxWeight - weight[n]);

        int notPick = topDown(weight, value, n - 1, maxWeight);
        int result = Math.max(pick, notPick);
        map[n][maxWeight] = result;
        return result;
    }

}