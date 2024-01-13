
import java.util.*;
import java.io.*;

public class MinimumSumPath {
    static int[][] map;

    public static int minSumPath(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        map = new int[row][col];
        // return topDown(grid, row, col, 0, 0);
        return bottomUp(grid, row, col);
    }

    // space optimized
    private static int bottomUp(int[][] grid, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int top = -1;
                int left = -1;
                int value;
                if (i - 1 >= 0)
                    top = grid[i - 1][j];
                if (j - 1 >= 0)
                    left = grid[i][j - 1];

                if (i == 0 && j == 0)
                    value = 0;
                else if (top == -1)
                    value = left;
                else if (left == -1)
                    value = top;
                else
                    value = Math.min(top, left);
                grid[i][j] += value;
            }
        }
        return grid[row - 1][col - 1];
    }

    private static int topDown(int[][] grid, int row, int col, int i, int j) {
        if (i == row - 1 && j == col - 1) {
            return grid[i][j];
        } else if (i >= row || j >= col) {
            return 100000;
        }
        if (map[i][j] != 0) {
            return map[i][j];
        }
        int cost = grid[i][j];
        // down
        int down = cost + topDown(grid, row, col, i + 1, j);
        // right
        int right = cost + topDown(grid, row, col, i, j + 1);
        map[i][j] = Math.min(down, right);
        return map[i][j];

    }

    public static void main(String[] args) {
        int[][] grid = {
                { 6, 9 },
                { 5, 20 }

        };
        int value = minSumPath(grid);
        System.out.println(value);
    }

}