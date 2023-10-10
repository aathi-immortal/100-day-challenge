import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringAtmostK {
    static Map<Character, Integer> map;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String arr = scan.nextLine();
            int k = scan.nextInt();

            int solution = kDistinctChars(k, arr);
            System.out.println(solution);
            scan.nextLine();
        }

    }

    public static int kDistinctChars(int k, String str) {
        map = new HashMap<>();
        return atmostGoal(k, str);
    }

    private static int atmostGoal(int goal, String str) {

        int head = 0;
        int end = 0;
        int max = 0;

        while (head < str.length()) {

            if (map.containsKey(str.charAt(head))) {
                map.put(str.charAt(head), map.get(str.charAt(head)) + 1);
            } else {
                map.put(str.charAt(head), 1);
            }

            while (map.size() > goal) {
                map.put(str.charAt(end), map.get(str.charAt(end)) - 1);
                if (map.get(str.charAt(end)) == 0) {
                    map.remove(str.charAt(end));
                }
                end++;
            }
            int size = (head - end + 1);
            // checking max value
            if (max < size) {
                max = size;
            }
            head++;
        }
        return max;
    }
}
