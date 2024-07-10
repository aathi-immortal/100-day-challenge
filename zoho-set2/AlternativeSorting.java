import java.util.ArrayList;
import java.util.Arrays;

public class AlternativeSorting {
    ArrayList<Long> alternateSort(long arr[], int N) {

        // sort the array
        // create dummy array
        // insert the data in alternatively
        ArrayList<Long> dummy = new ArrayList<>();
        Arrays.sort(arr);
        int lastIndex = N - 1;
        int firstIndex = 0;
        while (firstIndex < lastIndex) {
            dummy.add(arr[lastIndex]);
            dummy.add(arr[firstIndex]);
            firstIndex++;
            lastIndex--;
        }
        if (firstIndex == lastIndex) {
            dummy.add(arr[firstIndex]);
        }
        return dummy;
    }
}
