import java.util.* ;
import java.io.*; 
public class Solution {

	public static char firstNonRepeatingCharacter(String str) {

		return usinfHash(str);
	}
	static char usinfHash(String str)
	{
		int[] map = new int[255];
        
		for(int i = 0;i< str.length();i++)
		{
			int characterIndex = str.charAt(i) ;
			map[characterIndex] += 1;
			
		}
        
		for(int i = 0;i<str.length();i++)
		{
			int characterIndex = str.charAt(i);
            if(map[characterIndex] == 1)
                return str.charAt(i);
		}
		return str.charAt(0);
	}
}