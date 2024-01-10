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


	static int  dynamicMaxSum(ArrayList<Integer> nums)
	{
		map.put(0,0);
		for(int i = 0;i<nums.size();i++)
		{
			int maxValue = Integer.MIN_VALUE;
			int value = 0;
			for(int j = i + 2;j< nums.size();j++)
			{
				if((i - j) > 0)
					value = map.get(i - j) + nums.get(i);
				else
					break;
				if(value > maxValue)
					value = maxValue;
			}
			map.put(i, value);
		}
	}

	static int topDownApproch(int n,ArrayList<Integer> nums)
	{
		if(n == 0)
			return nums.get(0);
		else if(n < 0)
			return 0;
		

		int pick = topDownApproch(n - 2, nums) + nums.get(n);
		int notPick = topDownApproch(n - 1, nums);

		return Math.max(pick, notPick);
	}
	static int bottomToTop(int n,ArrayList<Integer> nums)
	{
		map.put(0, 0);
		int pickedValue,notPickedValue;
		for(int i = 0;i<nums.size() ;i++)		
		{
			
			if(i - 2 > 0)
				pickedValue = map.get(i - 2);
			else
				pickedValue  = 0;
			
			if(i - 1 > 0)
				notPickedValue = map.get(i - 1);
			else
				notPickedValue = 0;


			int picked = nums.get(i) + pickedValue;
			map.put(i,Math.max(picked,notPickedValue));

		}
		return map.get(nums.size() - 1);

	}

	// O(n) -> time
	// O(1) -> space
	static int bottomUpSpaceOptimized(int n,ArrayList<Integer> array)
	{
			int prev1 = 0;
			int prev2 = 0;
			for(int i = 0;i<array.size() - 1;i++)		
			{
				
				int picked = array.get(i) + prev1;

				int notPicked = prev2;

				prev2 = prev1;
				prev1 = Math.max(picked, notPicked);
			}
			return prev1;
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