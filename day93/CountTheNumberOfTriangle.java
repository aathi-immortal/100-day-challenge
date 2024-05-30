import java.util.Arrays;

public class CountTheNumberOfTriangle {
    static int count;

    static int findNumberOfTriangles(int arr[], int n) {
        count = 0;

        Arrays.sort(arr);
        int index = n - 1;
        while (index > 1) {
            int cLength = arr[index];
            findValidAandB(index - 1, arr, cLength);
        }
        return count;
    }

    private static void findValidAandB(int end, int[] arr, int cLength) {
        int start = 0;

        while (start < end) {
            int sumAandB = arr[start] + arr[end];
            if (sumAandB > cLength) {
                count += (start - end);
                end--;
                start = 0;
            } else {
                start++;
            }

        }
    }

    public static void main(String[] args) {

        int n = 20;
        for (int i = 1; i < Math.sqrt(n); i++) {
            System.out.println(i);
        }

    }

}
