import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueBinaryRows {
    static Map<Integer, Integer> map;

    public static void main(String[] args) {

        int[][] arr = { { 1, 1, 0, 1 }, { 1, 0, 0, 1 }, { 1, 1, 0, 1 } };
        uniqueRow(arr, 0, 0);
    }

    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][], int r, int c) {
        map = new LinkedHashMap<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // load it into hashMap
        loadToHashMap(a);
        // traverse the HashMap values
        for (int key : map.keySet()) {

            ans.add(intToBinArray(key, c));

        }
        return ans;
    }

    private static ArrayList<Integer> intToBinArray(int key, int col) {
        ArrayList<Integer> binary = new ArrayList<>();
        while (col != 0) {
            binary.add(key % 2);
            key /= 2;
            col--;
        }
        reverse(binary);
        return binary;
    }

    private static void reverse(ArrayList<Integer> binary) {
        int start = 0;
        int end = binary.size() - 1;
        while (start < end) {
            int tem = binary.get(start);
            binary.set(start, binary.get(end));
            binary.set(end, tem);
            start++;
            end--;
        }

    }

    private static void loadToHashMap(int[][] a) {
        for (int[] innerArray : a) {
            // convert it into int
            int intValue = binToInt(innerArray);
            if (map.containsKey(intValue)) {
                map.put(intValue, map.get(intValue) + 1);
            } else {
                map.put(intValue, 1);
            }

        }
    }

    private static int binToInt(int[] innerArray) {
        int result = 0;
        int base = innerArray.length - 1;
        for (int data : innerArray) {
            result += (int) Math.pow(2, base) * data;
            base--;
        }
        return result;
    }

}
