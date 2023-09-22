package day7;

public class FindMinInRotatedArray {
    public static boolean isRotated(int[] arr) {
        if (arr[0] <= arr[arr.length - 1]) {
            return false;
        }
        return true;
    }

    public static int findMin(int[] arr) {
        int n = arr.length;
        int start = 0;

        int end = n - 1;
        if (!isRotated(arr)) {
            return arr[0];
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            if (start == end) {
                return arr[mid];
            } else if (mid - 1 > -1 && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            } else if (mid + 1 < arr.length && arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }

            // else if(arr.get(start) <= arr.get(end))
            // {
            // // use binary search
            // // return it
            // }
            // left region or right region
            else if (arr[mid] < arr[start]) {
                // right portion

                end = mid - 1;

            } else {
                // left portion

                start = mid + 1;

            }
        }
        return 0;
    }
}
