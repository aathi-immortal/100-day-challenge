import java.util.* ;
import java.io.*; 
public class HouseRobber{


	public static long houseRobber(int[] valueInHouse) {
				
		if(valueInHouse.length == 1)
            return valueInHouse[0];
		return Math.max(bottomUp(valueInHouse,0,valueInHouse.length - 1),bottomUp(valueInHouse, 1, valueInHouse.length));

	}	
	static int bottomUp(int[] array,int start,int end)
	{
        
		int prev1 = 0;
		int prev2 = 0;
		int n = array.length;
		
		
		
		for(int i = start;i<end;i++)
		{
			
			
			int picked = prev2 + array[i];
			int notPicked = prev1;
			prev2 =  prev1;
			prev1 = Math.max(picked, notPicked);
		}
		
		return prev1;
	}
}