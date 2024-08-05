import java.util.Arrays;

public class TrainPlatform {
    static int findPlatform(int arr[], int dep[], int n) {

        Arrays.sort(arr);
        Arrays.sort(dep);
        int arrIndex = 0;
        int depIndex = 0;
        int count = 0;
        int max = 0;
        while (arrIndex < n) {
            int arrival = arr[arrIndex];
            int departure = dep[depIndex];
            if (arrival <= departure) {
                count++;
                arrIndex++;
            } else {
                count--;
                depIndex++;
            }
            max = Math.max(max, count);
        }
        return max;

    }

}
