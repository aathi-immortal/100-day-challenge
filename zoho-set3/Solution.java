import java.io.*;
import java.util.*;

import java.util.ArrayList;

public class Solution {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        // int[][] ans = new int[n][m];
        // for(int[] arr: ans) Arrays.fill(arr, Integer.MIN_VALUE);
        if (m == 1 || n == 1)
            return;

        int iStart = 0;
        int jStart = 0;
        int iEnd = n;
        int jEnd = m;
        while (iStart < iEnd && jStart < jEnd) {
            rotate(iStart, jStart, iEnd, jEnd, mat);
            iStart += 1;
            jStart += 1;
            iEnd -= 1;
            jEnd -= 1;
        }

        // for(int i=0;i<n;i++) {
        // for(int j=0;j<m;j++) {
        // if(ans[i][j]==Integer.MIN_VALUE) continue;
        // else mat.get(i).set(j, ans[i][j]);
        // }
        // }

    }

    public static void rotate(int i, int j, int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int row = n - i;
        int col = m - j;
        int prev = mat.get(0).get(0);
        int current;
        if (row == 1 || col == 1)
            return;
        // first row

        for (int idx = j; idx < m - 1; idx++) {
            current = mat.get(i).get(idx + 1);
            mat.get(i).set(idx + 1, prev);
            prev = current;
        }

        // last col
        for (int idx = i; idx < n - 1; idx++) {
            current = mat.get(idx + 1).get(m - 1);
            mat.get(idx + 1).set(m - 1, prev);
            prev = current;
        }

        // last row

        for (int idx = m - 1; idx > j; idx--) {

            current = mat.get(n - 1).get(idx - 1);
            mat.get(n - 1).set(idx, prev);
            prev = current;
        }

        // first col
        for (int idx = n - 1; idx > i; idx--) {
            current = mat.get(idx - 1).get(j);
            mat.get(idx).set(j,prev);
            prev = current;
        }
    }
}