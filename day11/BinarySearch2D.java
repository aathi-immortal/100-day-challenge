package day11;

import java.util.ArrayList;
import java.util.Scanner;

import io.ArrayIo;

public class BinarySearch2D {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            ArrayList<ArrayList<Integer>> array = ArrayIo.build2dArrayList();
            int target = scan.nextInt();

            System.out.println(searchMatrix(array, target));
        }

    }

    public static int coloumnBinarySearch(ArrayList<ArrayList<Integer>> mat, int target) {
        int start = 0;
        int end = mat.size() - 1;
        int mid = -1;
        int col = mat.get(0).size() - 1;

        while (start <= end) {
            mid = (start + end) / 2;
            if (mat.get(mid).get(col) == target) {
                return mid;
            } else if (mat.get(mid).get(col) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }

    public static boolean binarySearch(ArrayList<ArrayList<Integer>> mat, int target, int row, int col) {
        int start = 0;
        int end = col;
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (mat.get(row).get(mid) == target) {
                return true;
            } else if (mat.get(row).get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int row = mat.size() - 1;
        int col = mat.get(0).size() - 1;
        // finding the correct row for the binarySearch
        int index = coloumnBinarySearch(mat, target);
        if (mat.get(index).get(col) < target) {
            index++;
        }
        if (index > row) {
            return false;
        }
        return binarySearch(mat, target, index, col);
    }
}
