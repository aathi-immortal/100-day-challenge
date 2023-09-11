import java.util.HashMap;
import java.util.Map;

public class ReverseMathLongestSum {
    public static int setMax(int size,int temSize)
    {
        return Math.max(temSize, size);
                
        
    }
    public static int longestSubarrayWithSumK(int []a, long k) {
        int i = 0;
        int j = 0;
        int sum = a[0];
        int size = 0;
        while(j < a.length - 1)
        {
            if(sum == k)
            {
                size = setMax(size, j - i + 1);
                sum += a[++j];        
            }
            else if(sum > k)
            {
                if(i == j)
                {
                    sum += a[++j];
                }
                sum -= a[i++];
            }
            else
            {
                sum += a[++j];
            }
            
        }
        if(sum == k)
        {
            size = setMax(size, j- i + 1);
        }
        return size;








        //        int i = 0;
        // int sum = 0;
        // int size = 0;
        // Map<Integer, Integer> map = new HashMap<>();
        // while (i < a.length) {
        //     sum += a[i];
        //     if ((long) sum == k) {
        //         size = Math.max(size, i + 1);
        //     }
            
        //     else if (map.containsKey((int) (sum - k))) {
        //             size = Math.max(size, i - map.get((int) (sum - k)));
        //             // System.out.println((sum - k) + " " + i + ":" + map.get((int) (sum - k)));
        //         }
        
        //     if(!map.containsKey(sum))
        //     {
        //         map.put(sum, i);
        //     }
        //     i++;
        // }
        // return size;

    }
 
    
} 
