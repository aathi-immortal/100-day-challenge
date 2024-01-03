import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {

	static Map<Integer,Integer> map;
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int index = -2;
		map = new HashMap<>();		
		return maxSum(index,nums);
	}
	static int maxSum(int index,ArrayList<Integer> array)
	{
		
		if(index >= array.size() - 2)
		{
			return 0;
			// return 0;

		}
		
				
		int max = 0;
		int value;
		
		for(int i = index + 2;i < array.size();i++)
		{
			
			
			if(map.containsKey(i))
			{
				value =  map.get(i);
			}
			else
			{
				value = maxSum(i, array) + array.get(i);
			
				map.put(i, value);
			}
				
			if(max < value)
			{
				max = value;
			}
		}
		return max;
	}
}