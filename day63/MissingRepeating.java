import java.util.*;
import java.io.*;

public class MissingRepeating {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        return MathApproch(arr, n);
    }

    private static int[] MathApproch(ArrayList<Integer> arr, int n) {
        // sum of arr elements
        long sumOfValues = sum(arr);

        long totalSum = n * (n + 1) / 2;

        // form the equation
        // x - y
        long eqOne = sumOfValues - totalSum;

        long sumOfSquare = sumOfSquare(arr);
        int totalSqaureSum = (n * (n + 1) * (2 * n + 1)) / 6;
        // equation two x2 - y2
        long eqTwo = sumOfSquare - totalSqaureSum;

        // equation x + y found using
        long eqThree = eqTwo / eqOne;
        // finding y value y is missing value
        long yValue = (eqThree - eqOne) / 2;
        long xValue = eqOne + yValue;
        int[] ans = { (int) yValue, (int) xValue };
        return ans;

    }

    private static long sumOfSquare(ArrayList<Integer> arr) {
        long sum = 0;
        for (int data : arr)
            sum += data * data;
        return sum;
    }

    private static long sum(ArrayList<Integer> arr) {
        long sum = 0;
        for (int data : arr)
            sum += data;
        return sum;
    }

    static int[] usingMap(ArrayList<Integer> arr, int n) {
        int repeated = findRepeatedValue(arr);
        long sumValue = sum(arr);
        long totalSum = n * (n + 1) / 2;
        int ans[] = { (int) (totalSum - sumValue + repeated), repeated };
        return ans;
    }

    static int findRepeatedValue(ArrayList<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int data : arr) {
            if (map.containsKey(data))
                return data;
            else
                map.put(data, 1);

        }
        return -1;

    }
oneo