import java.util.*;
import java.io.*;

public class Solution {
    public static void sort012(int[] arr) {

        // approchOne(arr);
        approchTwo(arr);
    }

    private static void approchTwo(int[] arr) {
        
    }

    private static void approchOne(int[] arr) {
        int[] temArray = new int[arr.length];
        // zero pick
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                temArray[index++] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                temArray[index++] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2)
                temArray[index++] = 2;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temArray[i];
        }

    }
}