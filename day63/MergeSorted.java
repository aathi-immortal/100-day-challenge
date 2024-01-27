import java.util.*;
public class MergeSorted {
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        optimalOne(a,b);
    }
    public static void optimalOne(long[] a,long[] b)
    {
        int leftPointer = a.length -1;
        int rightPointer = 0;
        while(leftPointer > -1 && rightPointer < b.length)
        {
            if(a[leftPointer] < b[rightPointer])
            {
                break;
            }
            long tem= b[rightPointer];
            b[rightPointer] = a[leftPointer];
            a[leftPointer] = tem;
            leftPointer--;
            rightPointer++;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        
    }
}