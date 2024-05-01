import java.io.*;
import java.util.*;

public class PairSum {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        pairSum(arr, 5);
    }

    public static List<int[]> pairSum(int[] arr, int s) {
        List<int[]> ans = new ArrayList<>();
        // use hash map
        HashMap<Integer, Integer> map = loadArrayToHashNap(arr);
        for (int index = 0; index < arr.length; index++) {
            int currentData = arr[index];
            int expectedData = s - currentData;
            map.put(currentData, map.get(currentData) - 1);
            if (map.get(expectedData) > 0) {
                for (int time = 0; time < map.get(expectedData); time++) {
                    int[] pair = { currentData, expectedData };
                    ans.add(pair);
                }
            }
        }
    }

    private static HashMap<Integer, Integer> loadArrayToHashNap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < arr.length; index++) {
            if (map.containsKey(arr[index])) {
                int newData = map.get(arr[index]) + 1;
                map.put(arr[index], newData);
            } else {
                map.put(arr[index], 1);
            }
        }
    }

    private static int[] createArray(int i, int j) {
        int[] array = { i, j };
        return array;

    }

}
