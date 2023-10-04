package day14;

import java.util.HashMap;

public class RomanToInteger {
    static HashMap<Character, Integer> map;

    static void loadHashMap() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static int convertor(String s) {
        int total = map.get(s.charAt(s.length() - 1));
        int value = 1;
        for (int i = s.length() - 2; i > -1; i--) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                value = -1;
            }
            total += map.get(s.charAt(i)) * value;
            value = 1;

        }
        return total;
    }

    public static int romanToInt(String s) {
        map = new HashMap<>();
        loadHashMap();
        return convertor(s);
    }

}