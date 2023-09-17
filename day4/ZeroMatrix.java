
import java.util.*;
import java.io.*;

public class ZeroMatrix {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        getMatrixInput(matrix);
        zeroMatrix(matrix, matrix.size(), matrix.get(0).size());
        printTheMatrix(matrix);
    }

    // generic method common for all datatypes which are in ArrayList Matix
    private static <T> void printTheMatrix(ArrayList<ArrayList<T>> matrix) {
        int row = matrix.size();
        int col = matrix.get(0).size();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void getMatrixInput(ArrayList<ArrayList<Integer>> matrix) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the matrix
        // Get the size of the matrix
        System.out.println("Enter the number of rows in the matrix: ");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of columns in the matrix: ");
        int columns = scanner.nextInt();

        // Get the input for the matrix one by one
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> temMatrix = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                System.out.println("Enter the element at row " + i + ", column " + j + ": ");

                temMatrix.add(scanner.nextInt());

            }
            matrix.add(i, temMatrix);
        }

        // Close the scanner
        scanner.close();

    }

    public static void zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
        // row and col array will track which row and col have zero

        // space compleity O(n + m)
        int row[] = new int[m];
        int col[] = new int[n];
        // now we are going to traver the matrix to identify the zero in the matrix

        // time complexity is O(n*m)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    row[j] = 1;
                    col[i] = 1;
                }
            }
        }
        // now traversing the row and col array which is used for tracking the matrix to
        // set the matrix to zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[j] == 1 | col[i] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

    }
}