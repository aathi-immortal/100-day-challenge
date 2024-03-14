import java.io.*;
import java.util.*;

import java.util.ArrayList;

public class FindDublicate {
    public static int findDuplicate(ArrayList<Integer> arr, int n) {
        return optimalOne(arr, n);
    }

    private static int optimalOne(ArrayList<Integer> arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int data : arr) {
            if (map.containsKey(data)) {
                return data;
            } else
                map.put(data, 1);
        }
    }
}
