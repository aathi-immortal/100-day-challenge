import java.util.HashMap;

public class IsAnagram {

    public static boolean isAnagram(String str1, String str2) {

        HashMap<Character, Integer> map = new HashMap<>();
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int index = 0; index < str1.length(); index++) {
            if (map.containsKey(str1.charAt(index)))
                map.put(str1.charAt(index), map.get(str1.charAt(index)) + 1);
            else
                map.put(str1.charAt(index), 1);
        }
        for (int index = 0; index < str1.length(); index++) {
            if (map.containsKey(str2.charAt(index))) {
                map.put(str2.charAt(index), map.get(str2.charAt(index)) - 1);
                if (map.get(str2.charAt(index)) == 0)
                    map.remove(str2.charAt(index));
            }

            else
                return false;
        }
        return true;

    }

}