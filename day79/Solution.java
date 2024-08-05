// import java.io.*;
// import java.util.*;

// public class PairSum {
//     public static void main(String[] args) {
//         int[] arr = { 1, 2, 3, 4, 5 };
//         pairSum(arr, 5);
//     }

//     public static List<int[]> pairSum(int[] arr, int s) {
//         List<int[]> ans = new ArrayList<>();
//         // use hash map
//         HashMap<Integer, Integer> map = loadArrayToHashNap(arr);
//         for (int index = 0; index < arr.length; index++) {
//             int currentData = arr[index];
//             int expectedData = s - currentData;
//             map.put(currentData, map.get(currentData) - 1);
//             if (map.get(expectedData) > 0) {
//                 for (int time = 0; time < map.get(expectedData); time++) {
//                     int[] pair = { currentData, expectedData };
//                     ans.add(pair);
//                 }
//             }
//         }
//     }

//     private static HashMap<Integer, Integer> loadArrayToHashNap(int[] arr) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int index = 0; index < arr.length; index++) {
//             if (map.containsKey(arr[index])) {
//                 int newData = map.get(arr[index]) + 1;
//                 map.put(arr[index], newData);
//             } else {
//                 map.put(arr[index], 1);
//             }
//         }
//     }

//     private static int[] createArray(int i, int j) {
//         int[] array = { i, j };
//         return array;

//     }

// }



import java.util.ArrayList;

import java.util.*;

public class Solution {
	ArrayList<Pair<Integer, Integer>> twoSum(ArrayList<Integer> arr, int target, int n) {
		ArrayList<Pair<Integer,Integer>> ans = new ArrayList<>();
		
        // use hash map
        HashMap<Integer, Integer> map = loadArrayToHashNap(arr);
        for (int index = 0; index < arr.size(); index++) {
            int currentData = arr.get(index);
            int expectedData = target - currentData;
            map.put(currentData, map.get(currentData) - 1);
            if (map.get(expectedData) > 0) {
				Pair<Integer,Integer> pair = new Pair(currentData,expectedData);
				ans.add(pair);
            }
        }
	}

	    HashMap<Integer, Integer> loadArrayToHashNap(ArrayList<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < arr.size(); index++) {
            if (map.containsKey(arr.get(index))) {
                int newData = map.get(arr.get(index)) + 1;
                map.put(arr.get(index), newData);
            } else {
                map.put(arr.get(index), 1);
            }
        }
    }


}




1 2
1 2
1 2
1 2
1 2
1 1
1 1
-1 -1
1 2
3 3
3 3
3 3
3 3
3 3
3 3
3 3
3 3
3 3


1 2
1 2
1 2
1 1
-1 -1
1 2
3 3
3 3
3 3
3 3
3 3