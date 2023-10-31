
// The problem is to count all the possible paths from
//  top left to bottom right of an MxN matrix with the constraints that from each cell you
//  can either move to right or down.

// companies --> zoho

import java.util.*;
import java.lang.*;
import java.io.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int M = Integer.parseInt(inputLine[0]);
            int N = Integer.parseInt(inputLine[1]);
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(M, N));
        }
    }
}

// } Driver Code Ends

class Solution {
    long count = 0;

    long numberOfPaths(int M, int N) {

        recursivePathFinder(M, N, 0, 0);
        return count;
    }

    // it take lots of space nearly n*m
    private void recursivePathFinder(int row, int col, int currentRow, int currentCol) {

        if (currentRow == row - 1 && currentCol == col - 1) {
            count++;
            return;
        } else if (currentCol >= col)

            return;

        else if (currentRow >= row)
            return;

        recursivePathFinder(row, col, currentRow, currentCol + 1);
        recursivePathFinder(row, col, currentRow + 1, currentCol);
    }
    public void  askToNeighbour(int row,int col)
    {   
        
    }

}

// main class
public class NumberOfPath {
    public static void main(String[] args) {

    }
}
