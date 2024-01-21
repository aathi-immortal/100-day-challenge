import java.util.*;
import java.io.*;

public class ZeroMatrix {
    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {

        // return approchOne(matrix, n, m);
        return spaceOptimized(matrix, n, m);

    }

    private static ArrayList<ArrayList<Integer>> spaceOptimized(ArrayList<ArrayList<Integer>> matrix, Integer n,
            Integer m) {
        int row = n;
        int col = m;

        // traverse the first row and first col
        boolean isZeroInRow = false;
        boolean isZeroInCol = false;
        // traveling vertically in the matrix
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            if (matrix.get(rowIndex).get(0) == 0)
                isZeroInRow = true;
        }

        // traveling horizontally
        for (int colIndex = 0; colIndex < col; colIndex++) {
            if (matrix.get(0).get(colIndex) == 0)
                isZeroInCol = true;
        }

        // traverse the matrix
        for (int rowIndex = 1; rowIndex < row; rowIndex++) {
            for (int colIndex = 1; colIndex < col; colIndex++) {
                if (matrix.get(rowIndex).get(colIndex) == 0) {
                    matrix.get(rowIndex).set(0, 0);
                    matrix.get(0).set(colIndex, 0);
                }

            }
        }

        for (int rowIndex = 1; rowIndex < row; rowIndex++) {
            for (int colIndex = 1; colIndex < col; colIndex++) {
                if (matrix.get(rowIndex).get(0) == 0 || matrix.get(0).get(colIndex) == 0) {
                    matrix.get(rowIndex).set(colIndex, 0);
                }
            }
        }

        if (isZeroInCol) {
            for (int i = 0; i < col; i++) {
                matrix.get(0).set(i, 0);
            }
        }
        if (isZeroInRow) {
            for (int i = 0; i < row; i++) {
                matrix.get(i).set(0, 0);
            }
        }
        return matrix;
    }

    private static ArrayList<ArrayList<Integer>> approchOne(ArrayList<ArrayList<Integer>> matrix, Integer n,
            Integer m) {

        // n => number of rows
        // m => number of col
        int col[] = new int[m];
        int row[] = new int[n];
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            for (int colIndex = 0; colIndex < m; colIndex++) {
                if (matrix.get(rowIndex).get(colIndex) == 0) {
                    row[rowIndex] = -1;
                    col[colIndex] = -1;

                }
            }
        }
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            for (int colIndex = 0; colIndex < m; colIndex++) {
                if (row[rowIndex] == -1 || col[colIndex] == -1) {
                    matrix.get(rowIndex).set(colIndex, 0);
                }
            }
        }
        return matrix;
    }
}