import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountDifferentK {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String arr = scan.nextLine();
            int k = scan.nextInt();
            int ans = countSubStrings(arr, k);
            System.out.println(ans);
        }

    }

    static Map<Character, Integer> map;
    // static void loadHashMap(String str,int k)
    // {
    // for(int i = 0;i<str.length();i++)
    // {

    // }
    // }
    public static int atleast(String str, int k) {
        map = new HashMap<>();
        int head = 0;
        int end = 0;
        int size = 0;
        if (k == 0)

            return 0;

        while (head < str.length()) {
            if (map.containsKey(str.charAt(head))) {
                map.put(str.charAt(head), map.get(str.charAt(head)) + 1);
            } else {
                map.put(str.charAt(head), 1);
            }
            while (map.size() > k) {
                map.put(str.charAt(end), map.get(str.charAt(end)) - 1);
                if (map.get(str.charAt(end)) == 0) {
                    map.remove(str.charAt(end));
                }
                end++;
            }
            size += (head - end + 1);
            head++;
        }
        return size;
    }

    public static int countSubStrings(String str, int k) {

        return atleast(str, k) - atleast(str, k - 1);
        // move the end until
    }
}
