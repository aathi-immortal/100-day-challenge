import java.util.ArrayList;

import io.ArrayIo;

public class RowWithMax1 {
    public static int binarySearch(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        int start = 0;
        int end = col - 1;
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (mid == 0 || matrix.get(row).get(mid) != matrix.get(row).get(mid - 1)) {
                if (matrix.get(row).get(mid) == 0) {
                    return mid + 1;
                }
                return mid;
            }
            // move right side
            else if (matrix.get(row).get(mid) == 0) {
                start = mid + 1;    
            }
            // move left side
            else {
                end = mid - 1;
            }
        }
        return mid;
    }

    // 0 1 1 1 1
    // 0 0 1 1 1
    // 0 0 0 0 1
    // 1 1 1 1 1
    // 0 0 1 1 1
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            int index = m - binarySearch(matrix, i, m);

            if (index > max) {
                max = index;
                maxIndex = i;
            }

        }
        return maxIndex;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> array = ArrayIo.build2dArrayList();
        maximumOnesRow(array, 5, 5);
    }
}
