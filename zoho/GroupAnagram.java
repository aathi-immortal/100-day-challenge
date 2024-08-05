
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // sort the current string
            String sortedString = sortString(str);
            // if it in map add it
            if (map.containsKey(sortedString)) {
                map.get(sortedString).add(str);
            }
            // if not create new key and add current str
            else {
                List<String> bucket = new ArrayList<>();
                bucket.add(str);
                map.put(sortedString, bucket);
            }

        }
        return mapToList(map);

    }

    private List<List<String>> mapToList(HashMap<String, List<String>> map) {
        List<List<String>> ans = new ArrayList<>();
        for (List<String> str : map.values()) {
            ans.add(str);
        }
        return ans;
    }

    private String sortString(String str) {
        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);
        return new String(strArray);

    }

    public static void main(String[] args) {
        String ar[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
        GroupAnagram h = new GroupAnagram();
        h.groupAnagrams(ar);
    }
}
