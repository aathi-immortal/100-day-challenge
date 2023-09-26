package day8;

import java.util.ArrayList;

import io.ArrayIo;

public class FindPeakElement {
    // public static int findPeakElement(ArrayList<Integer> arr) {
    // if (arr.size() == 1)
    // return 0;
    // int mid= 0;

    // while (arr.size() > i) {
    // if ((mid!= 0 && arr.get(mid- 1) > arr.get(i)) || (mid!= arr.size() - 1 &&
    // arr.get(mid+ 1) > arr.get(i))) {
    // i++;
    // continue;

    // } else
    // return i;

    // }
    // return -1;
    // }

    public static void main(String[] args) {
        int value = findPeakElement(ArrayIo.buildArrayList());
        System.out.println(value);
    }

    public static int findPeakElement(ArrayList<Integer> arr) {
        if (arr.size() == 1)
            return 0;
        // use binary search
        int start = 0;
        int end = arr.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            // we are in right region move to left side

            if ((mid != 0 && arr.get(mid - 1) > arr.get(mid))) {

                end = mid - 1;
            }
            // we are in left region move to right side
            else if ((mid != arr.size() - 1 && arr.get(mid + 1) > arr.get(mid))) {

                start = mid + 1;
            }
            // we are neither in left side nor in right side we are in the peak point
            else {
                return mid;
            }
        }
        return -1;
    }

}