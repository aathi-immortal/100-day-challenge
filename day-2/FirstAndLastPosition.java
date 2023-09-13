import java.util.ArrayList;

public class FirstAndLastPosition {

    static int binarySearch(ArrayList<Integer> arr, int k) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr.get(mid) == k)
                return mid;
            else if (arr.get(mid) > k)
                right = mid - 1;
            else
                left = mid + 1;

        }
        return -1;

    }

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        int index = binarySearch(arr, k);

        int ans[] = new int[2];
        ans[0] = 0;
        ans[1] = n - 1;

        if (index == -1) {
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }

        for (int i = index; i < n; i++) {
            if (arr.get(i) != k) {
                ans[1] = i - 1;
                break;
            }
        }
        for (int i = index; i > -1; i--) {

            if (arr.get(i) != k) {
                ans[0] = i + 1;
                break;
            }
        }
        return ans;

    }

};
