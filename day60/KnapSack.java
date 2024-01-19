

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
public class Solution{
    static int map[][];
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
                map = new int[n][maxWeight + 1];
                    return topDown(weight, value, n - 1, maxWeight);
    }

    private static int topDown(int[] weight, int[] value, int n, int maxWeight) {


        
        
        if (maxWeight < 0 || n < 0)
            return 0;
        else if ((n == 0 && weight[n] <= maxWeight)) {
            return value[n];
            }
        else if(map[n][maxWeight] != 0)  
            return map[n][maxWeight];

    int pick = Integer.MIN_VALUE;
    if(weight[n] <= maxWeight)
        pick = value[n] + topDown(weight, value, n - 1, maxWeight - weight[n]);

    int notPick = topDown(weight, value, n - 1, maxWeight);
    int result = Math.max(pick, notPick);
    map[n][maxWeight] = result;
    return result;
    }
    
}