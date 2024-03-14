import java.util.*;
import java.io.*;

public class Solution {
    static int mod = 1000000007;

    public static int countPartitions(int n, int d, int[] arr) {
        int sum = totalSum(arr);
        if (sum % 2 == 0)
            sum = (sum / 2) - d;
        else
            sum = (sum / 2) - d - 1;
        int total = 0;
        for(int i = sum;i>0;i--)
        {
            total += bottomUp(n, i, arr);
        }
        return total;
    }

    private static int totalSum(int[] arr) {
        int sum = 0;
        for (int data : arr) {
            sum += data;
        }
        return sum;
    }

    public static int bottomUp(int n, int sum, int[] arr) {
        int[][] t = new int[n + 1][sum + 1];
        t[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = (t[i - 1][j] + t[i - 1][j - arr[i - 1]]) % mod;
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum] % mod;
    }
}