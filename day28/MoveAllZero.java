package day28;

//{ Driver Code Starts

//Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MoveAllZero {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr, int n) {
        int start = 0;
        int count = 0;

        while (start < n) {
            if (count > 0 && arr[start] != 0) {
                arr[start - count] = arr[start];
            } else if (arr[start] == 0) {
                count++;
            }
            start++;
        }
        // add the n number of zeros in the end of the array
        for (int i = n - count; i < n; i++) {
            arr[i] = 0;
        }
    }
}
