import java.util.*;
import java.io.*;

public class Solution {
    public static int countDistinctWayToClimbStair(long nStairs) {
        // loop it untill we found -1
        long numberOf1 = nStairs;
        long numberOf2 = 0;

        int numberOfWays = 0;
        int i = 0;

        while (numberOf1 < 0) {
            numberOfWays += (int) (fact(nStairs - i) / (fact(numberOf1) * fact(numberOf2)));
            numberOf1 -= 2;
            numberOf2 += 1;
            i++;
        }
        return numberOfWays;

    }

    private static int fact(long l) {
        
        int ans = 1;
        for(int i =1;i<=l;i++)
        {
            ans *= i;
        }
        return  ans;
    }
}
