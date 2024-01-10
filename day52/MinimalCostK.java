import java.util.HashMap;
import java.util.Map;

public class Solution {

    static Map<Integer,Integer> map;
    public static int minimizeCost(int n, int k, int []height){
        
        



        map = new HashMap<>();
        return optimalJump(n,k,height);
    }


    // top to bottom with mimoziation
    static int optimalJump(int n,int k,int[] height)
    {
        if(n == 0)
            return 0;
        int minValue = Integer.MAX_VALUE;
        int value = 0;

        if(map.containsKey(n))
        {
            return map.get(n);
        }

        for(int i = 1;i<=k;i++)
        {
            if(n - i >0)
                value = optimalJump(n - i, k, height) + Math.abs(height[n - 1] - height[n - i - 1]);
            if(value < minValue)
                minValue = value;
        }
        map.put(n, minValue);
        return minValue;

    }

    static int optimalJumpTabulation(int n,int k,int[] height)
    {

            map.put(0,0);
            for(int i = 0;i<n;i++)
            {
                
                

                // int value = map.get(i - 1) + Math.abs(height[i] - height[i - 1]);
                // int value2 = map.get(i - 2) + Math.abs(height[i] - height[i - 2]);
                // .
                // .
                // .
                // int value k = map.get(i - k) + Math.abs(height[i] - height[i - k]);
                int cost = Integer.MAX_VALUE;
                for(int j = 1;j<=k;j++)
                {
                    int value;
                        if(n - j > 0)
                        {
                                value = map.get(j - i) + Math.abs(height[i] - height[i - j]);
                        }
                        else
                            break;
                    if(value < cost)
                        cost = value;
                }



            }
            return map.get(n - 1);
    }





}