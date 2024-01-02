import java.util.* ;
import java.io.*; 
public class  FrogJump{


    static Map<Integer,Integer> map;
    public static int optimalJump(int n,int[] heights)
    {
        if(n <= 1)
        {
            return 0;
        }
        int leftIndex = n - 1;
        int rightIndex = n - 2;
        int leftChildEnergy;
        int rightChildEnergy;
        if(map.containsKey(leftIndex))
        {
            leftChildEnergy = map.get(leftIndex);
        }
        else
        {
             leftChildEnergy = optimalJump(leftIndex, heights);
             map.put(leftIndex, leftChildEnergy);
        }
        if(map.containsKey(rightIndex))
        {
            rightChildEnergy = map.get(rightIndex);
        }
        else
        {
             rightChildEnergy = optimalJump(rightIndex, heights);
             map.put(rightIndex, rightChildEnergy);
        }
        
        
        int fromLeft = Integer.MAX_VALUE;
        int fromRight = Integer.MAX_VALUE;

        if(leftIndex > 0)
        {
            fromLeft = Math.abs(heights[n - 1] - heights[leftIndex - 1]) + leftChildEnergy;
        }
        if(rightIndex > 0)
        {
            fromRight = Math.abs(heights[n - 1] - heights[rightIndex - 1]) + rightChildEnergy;
        }

        if(fromRight < fromLeft)
            return fromRight;
        
        
        return fromLeft;
        
    }
    public static int frogJump(int n, int heights[]) {
        map = new HashMap<>();
        return optimalJump(n,heights);
    }

}