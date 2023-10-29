
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
    // M * N time complexity 
    // N space complexity
long optimalSolution(int row,int col)
    {
        if(row == 0 || col == 0)
        {
            return 1;
        }
        int[] array = new int[col];
        // array initalization
        for(int i = 0;i<col;i++)
        {
            array[i] = 1;
        }
        for(int i = 0;i<row;i++)
        {
            int previous = 1;
            for(int j = 0;j<col;j++)
            {
                array[j] = (array[j] + previous) % ((int)Math.pow(10,9) + 7);
                previous = array[j];
            }
        }
        return array[col - 1];
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
        long optimizedNoRecursion(int row,int col)
    {
        int currentRow = 1;
        int currentCol = 1;
        for(currentRow = 1;currentRow < row;currentRow++ )
        {
            for(currentCol = 1;currentCol < col;currentCol++)    
            {
                
                int left = (currentCol - 1 == 0)?1:array.get(currentRow).get(currentCol - 1);
                int top = (currentRow - 1 == 0)?1:array.get(currentRow - 1).get(currentCol);
                
                array.get(currentRow).set(currentCol,(left + top)%((int)Math.pow(10,9) + 7)) ;        
            }
        }
        return array.get(currentRow - 1).get(currentCol - 1);
        
        
    }
// main class
public class NumberOfPath {
    public static void main(String[] args) {

    }
}
