import java.util.ArrayList;
import java.util.HashMap;

/**
 * LongestCosectuive
 */
public class LongestCosectuive {
    static ArrayList<Integer> subSquence;
    static int max;

    static int findLongestConseqSubseq(int arr[], int N) {
        max = 0;
        subSquence = new ArrayList<>();
        recSol(arr, N, 0);
        return max;
    }

    private static void recSol(int[] arr, int n, int currenIndex) {
        // base case
        if (currenIndex == n) {
            max = Math.max(subSquence.size(), max);
            return;
        }
        // pick
        int currentValue = arr[currenIndex];
        if (validCurrentValue(currentValue)) {
            subSquence.add(currentValue);
            recSol(arr, n, currenIndex + 1);
            subSquence.remove(subSquence.size() - 1);
        }

        // not pick
        recSol(arr, n, currenIndex + 1);

    }

    private static boolean validCurrentValue(int currentValue) {
        if (subSquence.size() == 0)
            return true;
        else if (currentValue - subSquence.get(subSquence.size() - 1) == 1)
            return true;
        return false;

    }

    public static void main(String[] args) {
        int[] arr = { 2, 6, 1, 9, 4, 5, 3 };
        int ans = findLongestConseqSubseq(arr, 7);
        System.out.println("\nvalue " + ans);

    }
}
