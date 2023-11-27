//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine().trim());

            Pattern ob = new Pattern();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.pattern(N);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Pattern {

    int modifier = -5;
    List<Integer> listOfValue;

    public void recursiveOperation(int newValue, int n) {
        if (newValue <= 0) {
            // changing the decrement to increment
            modifier = 5;
        } else if (newValue > n) {
            // pattern end
            return;
        }
        // adding the value into the list
        listOfValue.add(newValue);
        // recursivly calling the function
        recursiveOperation(newValue + modifier, n);
    }

    public List<Integer> pattern(int N) {
        listOfValue = new ArrayList<>();
        if (N < 0)
            listOfValue.add(N);

        else
            recursiveOperation(N, N);
        return listOfValue;
    }
}