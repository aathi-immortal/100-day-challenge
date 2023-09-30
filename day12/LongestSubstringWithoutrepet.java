package day12;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstringWithoutrepet {
    static int start = 0;
    static int i = 0;
    static int count = 0;
    static int max = 0;
    static HashMap<Character, Integer> map = new HashMap<>();

    public static void remveUptoIndex(int index, String input) {
        int i = start;
        while (i <= index) {
            map.remove(input.charAt(i++));
            count--;
        }
        start = i--;
    }

    public static int uniqueSubstrings(String input) {

        while (i < input.length()) {

            // repeated character
            if (map.containsKey(input.charAt(i))) {
                // get the duplicate value index
                // change the start to index + 1
                // remove the value from start to same value in hashMap
                int index = map.get(input.charAt(i));
                // remove values from the hsah map upto index
                remveUptoIndex(index, input);

            }

            count++;
            // fiding maximum
            map.put(input.charAt(i), i);

            if (max < count) {
                max = count;
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int data = uniqueSubstrings(scan.nextLine());
        System.out.println(data);
    }
}
