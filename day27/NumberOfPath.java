
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

}
 long askToNeighbour(int row,int col,int currentRow,int currentCol)
        {
            if(currentRow == 0 || currentCol == 0)
            {
                return  1;
            }
            // adding the nighbour value
            return (long)askToNeighbour(row,col, currentRow,currentCol - 1) + askToNeighbour(row,col, currentRow - 1,currentCol);
            
            
        }
        long optimizedAskToNeighbour(int row,int col,int currentRow,int currentCol)
        {
                if(currentRow == 0 || currentCol == 0)
            {
                return  1;
            }
            else if(array[currentRow][currentCol] != 0)
            {
                return    array[currentRow][currentCol];
            }
            array[currentRow][currentCol]  = ((long)optimizedAskToNeighbour(row,col, currentRow,currentCol - 1) + optimizedAskToNeighbour(row,col, currentRow - 1,currentCol)) % ((long)Math.pow(10,9) + 7);
            return array[currentRow][currentCol];
                
        }
       
// main class
public class NumberOfPath {
    public static void main(String[] args) {

    }
}
