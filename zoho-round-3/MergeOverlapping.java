import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlapping {

    public static void main(String[] args) {
        int[][] array = { { 1, 2 }, { 4, 5 } };
        MergeOverlapping mergeOverlapping = new MergeOverlapping();
        mergeOverlapping.merge(array);
    }

    public int[][] merge(int[][] intervals) {
        // sort the array based on the point one
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }

        });
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        int index = 1;
        while (index < intervals.length) {
            if (end >= intervals[index][0]) {
                // update end
                if (end < intervals[index][1])
                    end = intervals[index][1];
            } else {
                array.add(insertPoint(start, end));
                start = intervals[index][0];
                end = intervals[index][1];
            }
            index++;
        }
        array.add(insertPoint(start, end));
        int[][] result = new int[array.size()][2];
        for (int i = 0; i < array.size(); i++) {
            result[i][0] = array.get(i).get(0);
            result[i][1] = array.get(i).get(1);
        }
        return result;
    }

    private ArrayList<Integer> insertPoint(int start, int end) {
        ArrayList<Integer> innerArray = new ArrayList<>();
        innerArray.add(start);
        innerArray.add(end);
        return innerArray;
    }

}
