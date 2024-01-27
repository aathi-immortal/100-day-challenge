import java.io.*;
import java.util.*;

import java.util.ArrayList;

class MatrixDim {
    int topLeftRow;
    int topLeftCol;
    int topRightRow;
    int topRightCol;
    int bottomLeftRow;
    int bottomLeftcol;
    int bottomRightRow;
    int bottomRightCol;

}

public class Solution {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {

        // n => row
        // m => col
        optimalSolution(mat, 0, m, n, m);
    }

    private static void optimalSolution(ArrayList<ArrayList<Integer>> mat,MatrixDim matrixDim) {
                int row = matrixDim.topLeftRow;
                int col = matrixDim.topLeftCol;
                // swaping 
                int rowIndex = row;
                int colIndex = col + 1;
                int tem;
                int previous = mat.get(row).get(col)
                while()
                {       
                    tem = mat.get(rowIndex).get(colIndex);
                    
                }

                    
    }

}
