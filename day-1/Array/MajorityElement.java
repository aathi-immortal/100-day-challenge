import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    static Map<Integer,Integer> map;
    static void loadTheHashMap(int[] v)
    {
        for(int data:v)
        {
            if(map.containsKey(data))
            {
                map.put(data,map.get(data) + 1);
            }
            else
            {
                map.put(data, 1);
            }
            
        }
    }
    static int getTheMaxCountValue()
    {
        int max = 0;
        int maxKey = -1;
        for(int key:map.keySet())
        {
            if(map.get(key) > max)
            {
                max = map.get(key);
                maxKey =   key;
            }
        }
        return maxKey;
    }
    public static int majorityElement(int []v) {
        map = new HashMap<>();
        loadTheHashMap(v);
        return getTheMaxCountValue();
    }
}