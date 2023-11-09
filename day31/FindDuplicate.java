package day31;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class FindDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    static ArrayList<Integer> array;
    static int size;

    public static void createArrayList(int n) {

        for (int i = 0; i < n; i++) {
            array.add(0);
        }
    }

    public static void setArrayList(int index, int data) {
        array.set(data, array.get(data) + 1);
    }

    public static void filterArrayList() {
        for (int i = 0; i < array.size();) {
            if (array.get(i) <= 1) {
                array.remove(i);
                continue;
            }

            i++;
        }
        if (array.size() == 0)
            array.add(-1);
    }

    public static void swapTheIndex() {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > 1) {
                if (i <= 1)
                    array.set(i, array.size() + 1);
                else
                    array.set(i, i);
            }
        }
    }

    public static ArrayList<Integer> duplicates(int arr[], int n) {
        array = new ArrayList<>();
        size = n;
        createArrayList(n);
        // traverse the array
        for (int i = 0; i < n; i++) {
            setArrayList(i, arr[i]);
        }

        swapTheIndex();

        // filter the arrayList
        filterArrayList();
        // int index = findTheOnePlace();
        // swapTheOneImage(index);
        swap0And1Index();

        return array;
    }

    // private static void swapTheOneImage(int index) {
    // if (index != -1)
    // array.set(index, 1);
    // }

    // private static int findTheOnePlace() {
    // if (isOneThere())
    // return ((array.get(0) == size + 1) ? 0 : 1);
    // return -1;
    // }

    // private static boolean isOneThere() {
    // if (array.get(0) == size + 1 || array.get(1) == size + 1)
    // return true;
    // return false;
    // }

    private static void swap0And1Index() {
        if (array.size() <= 1)
            return;
        if (array.get(1) == size + 1) {
            array.set(1, 1);
            array.set(0, 0);
        } else if (array.get(0) == size + 1)
            array.set(0, 1);

    }

    private static void displayList() {
        for (int data : array) {
            System.out.print(data + " ");
        }
        System.out.println();
    }
}
