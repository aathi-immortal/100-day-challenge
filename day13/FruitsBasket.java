package day13;

import java.util.HashMap;

import io.ArrayIo;

// 10 8 25 3 23 3 3 28 2 24 7 2 22 12 18 16 1 16 6 1 6 20 10 3 2 0 25 5 14 

public class FruitsBasket {
    public static int findMaxFruits(int[] arr, int n) {
        if (arr.length == 1) {
            return 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        int end = 0;
        int max = 0;
        int count = 0;
        while (end < n) {
            if (map.size() < 2) {
                map.put(arr[end], 1);
            } else if (!map.containsKey(arr[end])) {
                map = new HashMap<>();
                map.put(arr[end], 1);
                count = 1;
            }
            count++;
            end++;

            // max check
            if (max < count) {
                max = count;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int[] arr = ArrayIo.buildArray();
        int value = findMaxFruits(arr, arr.length);
        System.out.println(value);
    }
}
