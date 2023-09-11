public class KadanesAlgo {
    public int maxSubArray(int[] arr) {

        int max = -1 * (int) Math.pow(10, 9) + 1;
        int i = 0;
        int sum = 0;
        while (i < arr.length) {

            sum += arr[i];
            if (sum < arr[i]) {
                sum = arr[i];
            }
            if (sum > max) {
                max = sum;

            } else if (sum <= 0) {
                sum = 0;

            }
            i++;

        }
        return max;

    }

}
