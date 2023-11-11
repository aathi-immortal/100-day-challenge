
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class RearrangeArray {
    public static void main(String[] args) throws IOException {

        // Scanner in = new Scanner(System.in);

        // int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // testcases
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            // size of array
            int n = Integer.parseInt(read.readLine());
            long[] arr = new long[n];

            String str[] = read.readLine().trim().split(" ");

            // adding elements to the array
            for (int i = 0; i < n; i++)
                arr[i] = Long.parseLong(str[i]);

            // StringBuffer sb = new StringBuffer();

            Solution ob = new Solution();

            // calling rearrange() function
            ob.rearrange(arr, n);
            StringBuffer sb = new StringBuffer();

            // appending and printing the elements
            for (int i = 0; i < n; i++)
                sb.append(arr[i] + " ");
            System.out.println(sb);
        }
    }
}

// } Driver Code Ends

class Solution {

    // temp: input array
    // n: size of array
    // Function to rearrange the array elements alternately.
    public static void moveRight(int start, long[] arr) {
        for (int i = arr.length - 2; i >= start; i--) {
            arr[i + 1] = arr[i];
        }
    }

    public static void rearrange(long arr[], int n) {

        int index = 0;
        while (index < n) {
            long lastValue = arr[n - 1];
            // move right
            moveRight(index, arr);
            displayArray(arr);
            arr[index] = lastValue;
            index += 2;
        }

    }

    private static void displayArray(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
