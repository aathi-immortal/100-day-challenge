import java.util.*;
import java.io.*;

public class Solution {

    public static char firstNonRepeatingCharacter(String str) {

        return usinfHash(str);
    }

    static char usinfHash(String str)
	{
		Map<Character,Integer> map = new HashMap<>();
		for(int i = 0;i< str.length();i++)
		{
			char character = str.charAt(i);
			if(map.containsKey(character))
				map.put(character,map.get(character) + 1);
			else
				map.put(character, 1);
			
		}
		for(char chr : map.keySet())
		{
			if(map.get(chr) == 1)
				return chr;
		}
		return str.charAt(0);
	}
}