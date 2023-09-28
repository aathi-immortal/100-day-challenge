public class FintRoot {
    public static int binarySearch(int n, int m) {
        int start = 0;
        int end = (m / 2) + 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = (int) Math.pow(mid, n);
            if (midValue == m) {
                return mid;
            } else if (midValue > m) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
