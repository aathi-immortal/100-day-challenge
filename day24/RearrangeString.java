package day24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class RearrangeString {
    static HashMap<Character, Integer> map;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("enter the string");
            String str = scan.nextLine();
            str = rearrangeString(str);
            System.out.println(str);
        }

    }

    public static void loadString(String str) {
        int i = 0;
        while (i < str.length()) {
            Character chr = str.charAt(i);
            if (map.containsKey(chr)) {
                map.put(chr, map.get(chr) + 1);
            } else {
                map.put(chr, 1);
            }
            i++;
        }
    }

    public static String rearrangeString(String str) {
        // traver the string and load it into the hash map
        StringBuffer ansStr = new StringBuffer();
        map = new HashMap<>();

        loadString(str);

        // it contain all character present in the string
        Set<Character> chrSet = new CopyOnWriteArraySet<>(map.keySet());

        // iterate over the chrSet until it become empty
        while (!chrSet.isEmpty()) {

            for (Character chr : chrSet) {
                // System.out.println((new ArrayList<>(chrSet)).get(0));
                if (chrSet.size() == 1 && map.get((new ArrayList<>(chrSet)).get(0)) > 1) {

                    return "no";
                }
                ansStr.append(chr);
                map.put(chr, map.get(chr) - 1);
                if (map.get(chr) == 0) {
                    chrSet.remove(chr);
                }
            }
        }
        return ansStr.toString();

    }
}
