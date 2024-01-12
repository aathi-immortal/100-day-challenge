
import java.util.*;
import java.io.*;

public class UniquePath {
    static int[][] map;

    public static int uniquePaths(int m, int n) {
        map = new int[m][n];
        int row = 0;
        int col = 0;
        return bottomUpApproch(m, n);
    }

    private static int topToBottom(int m, int n, int row, int col) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        } else if (row == m || col == n) {
            return 0;
        }

        // right
        int value = topToBottom(m, n, row, col + 1);
        // down
        value += topToBottom(m, n, row + 1, col);
        return value;
    }

    static int topToBottomMimoziation(int m, int n, int row, int col) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        } else if (row == m || col == n) {
            return 0;
        }
        if (map[row][col] != 0) {
            return map[row][col];
        }
        // right

        int value = topToBottom(m, n, row, col + 1);

        // down
        value += topToBottom(m, n, row + 1, col);
        map[row][col] = value;
        return value;
    }

    static int bottomUpApproch(int row, int col) {
        map[0][0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int value = 0;
                // move left
                if (j - 1 > -1) {
                    value += map[i][j - 1];
                }
                // mode up
                if (i - 1 > -1) {
                    value += map[i - 1][j];
                }
                else if(i - 1 < 0 && j - 1 < 0)
                {
                    value = 1;
                }
                map[i][j] = value;

            }
        }
        return map[row - 1][col - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 2));
    }
}