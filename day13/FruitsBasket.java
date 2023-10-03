package day13;

import java.util.HashMap;

import io.ArrayIo;

// 10 8 25 3 23 3 3 28 2 24 7 2 22 12 18 16 1 16 6 1 6 20 10 3 2 0 25 5 14 

public class FruitsBasket {

    public static int findMaxFruits(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        while (end < n) {
            // window stringing
            if (!map.containsKey(arr[end]) && map.size() == 2) {
                // window will string untill we have 2 unique value
                while (map.size() == 2) {
                    map.put(arr[start], map.get(arr[start]) - 1);
                    if (map.get(arr[start]) == 0) {
                        map.remove(arr[start]);
                    }
                    start++;

                    // if(map.containsKey(map.get(arr[start])))
                    // {

                    // }
                }
            }
            // window increasing
            if (map.containsKey(arr[end])) {
                map.put(arr[end], map.get(arr[end]) + 1);
            } else {
                map.put(arr[end], 1);
            }
            end++;

            // max value
            if (max < (end - start)) {
                max = (end - start);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        while (true) {
            int[] arr = ArrayIo.buildArray();
            int value = findMaxFruits(arr, arr.length);
            System.out.println(value);
        }

    }
}
