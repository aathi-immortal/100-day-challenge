import java.util.ArrayList;
import java.util.Collections;

public class SortMatrixDiagonal {

    public int[][] diagonalSort(int[][] mat) {

        int matrixRow = mat.length;
        int matrixCol = mat[0].length;

        // traverse the matrix

        // move up
        for (int row = matrixRow; row >= 0; row--) {
            ArrayList<Integer> temArray = createSubArray(mat, row, 0);
            Collections.sort(temArray);
            loadTOMatrix(mat, temArray, row, 0);
        }
        // move right
        for (int col = 0; col <= matrixCol; col++) {
            ArrayList<Integer> temArray = createSubArray(mat, 0, col);
            Collections.sort(temArray);
            loadTOMatrix(mat, temArray, 0, col);
        }
        return mat;
    }

    private void loadTOMatrix(int[][] mat, ArrayList<Integer> temArray, int row, int col) {

        for (Integer value : temArray) {

            mat[row][col] = value;
            row++;
            col++;
        }

    }

    private ArrayList<Integer> createSubArray(int[][] mat, int row, int col) {
        int matrixRow = mat.length;
        int matrixCol = mat[0].length;
        ArrayList<Integer> temArray = new ArrayList<>();
        while (row <= matrixRow && col <= matrixCol) {
            int currentValue = mat[row][col];
            temArray.add(currentValue);
            row++;
            col++;
        }
        return temArray;

    }

}
