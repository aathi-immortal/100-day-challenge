public class CountInversion {

    public static long getInversions(long arr[], int n) {
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j])
                    count++;
            }
        }
        return count;
    }
}k
