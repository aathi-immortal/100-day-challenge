package day6;

import java.util.ArrayList;

public class SearchInRotatedArray {
    public static void main(String[] args) {

        // String input = "10 11 1 2 3 4 5 6 9";
        // String[] inoutArray = input.split(" ");
        // ArrayList<Integer> values = new ArrayList<>();
        // for (String value : inoutArray) {
        // values.add(Integer.parseInt(value));
        // }
        // search(values, 9, 9);
    }
    // public static int binSearch(ArrayList<Integer> arr,int k)
    // {
        
    // }
    public static int search(ArrayList<Integer> arr, int n, int k) {
        // isRoatedOrNot
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr.get(mid) == k) {
                return mid;
            }
            // else if(arr.get(start) <= arr.get(end))
            // {
            // // use binary search
            // // return it
            // }
            // left region or right region
            else if (arr.get(mid) < arr.get(start)) {
                // right portion
                if (arr.get(mid) < k && arr.get(end) >= k) {
                    start = mid + 1;

                } else {
                    end = mid - 1;
                }

            } else if (arr.get(mid) > arr.get(start)) {
                // left portion
                if (arr.get(mid) > k && arr.get(start) <= k) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;

    }
}

// There is an integer array nums sorted in ascending order (with distinct
// values).

// Prior to being passed to your function, nums is possibly rotated at an
// unknown pivot index k (1 <= k < nums.length) such that the resulting array is
// [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
// (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
// and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target,
// return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.