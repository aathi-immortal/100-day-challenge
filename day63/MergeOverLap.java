import java.util.ArrayList;
import java.util.List;

public class MergeOverLap {
    public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {

        return approchFirst(arr);
    }

    private static List<List<Integer>> approchFirst(int[][] arr) {

        int margin = arr[0][1];
        int start = 0;
        List<List<Integer>> array = new ArrayList<>();
        // traverse the array
        int index;
        for (index = 1; index < arr.length; index++) {
            // you are outside the margin not overlaped
            if (margin < arr[index][0]) {

                List<Integer> innerArray = new ArrayList<>();
                innerArray.add(arr[start][0]);

                innerArray.add(arr[index - 1][1]);

                array.add(innerArray);

                start = index;
            }
            if (margin < arr[index][1]) {
                margin = arr[index][1];
            }
        }
        List<Integer> innerArray = new ArrayList<>();
        innerArray.add(arr[start][0]);

        innerArray.add(arr[index - 1][1]);

        array.add(innerArray);

        return array;
    }

    public static void main(String[] args) {
        int[][] arr = {

                { 2, 2 },
                { 2, 3 },
                { 2, 5 },
                { 3, 6 },
                { 4, 4 },
                { 4, 5 },
                { 6, 6 }

        };
        mergeOverlappingIntervals(arr);
    }
}