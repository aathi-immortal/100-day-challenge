package day19;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.List;

public class SortingCharactersFrequency {
    static Map<Character, Integer> map;

    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            String name = scan.nextLine();
            String ans = sortByFrequency(name.length(), name);
            System.out.println(ans);
        }
    }

    public static List<Entry<Character, Integer>> sortTheMapByValue() {

        List<Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        return entries;

    }

    public static String sortByFrequency(int n, String s) {
        map = new HashMap<>();
        String answer = "";
        // load the string into the hashMap
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }
        // sort the hashmap based on the value
        List<Entry<Character, Integer>> entries = sortTheMapByValue();
        // traverse the entries array from the last and add it to the new String

        for (int i = entries.size() - 1; i > -1; i--) {
            int j = entries.get(i).getValue();
            while (j > 0) {
                answer += entries.get(i).getKey();
                j--;
            }
            // System.out.println(entries.get(i).getKey());
            // System.out.println(entries.get(i).getValue());
        }

        return answer;
    }
}
