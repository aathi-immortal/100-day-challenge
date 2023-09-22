package day7;

import java.util.ArrayList;

import io.ArrayIo;

public class SingleElementInArray {
    static int advanceBinarySearch(ArrayList<Integer> arr, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid > 0 && arr.get(mid) == arr.get(mid - 1)) {
                // if the mid value is odd then our target value is in right side from the mid
                if (mid % 2 == 1) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (mid < arr.size() - 1 && arr.get(mid) == arr.get(mid + 1)) {
                if (mid % 2 == 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                return arr.get(mid);
            }
        }
        return -1;

    }

    public static int singleNonDuplicate(ArrayList<Integer> arr) {
        if (arr.size() == 1)
            return arr.get(0);
        return advanceBinarySearch(arr, 0, arr.size() - 1);
    }

    public static void main(String[] args) {

        int value = singleNonDuplicate(ArrayIo.buildArrayList());
        System.out.println(value);
    }
}