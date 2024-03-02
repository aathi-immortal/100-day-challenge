import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        return usingHashMap(nums);
    }

    private int usingHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        // get the frequency of all element
        for (int data : nums) {
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
        }

        for (int data : map.keySet()) {
            total += sumOf(map.get(data) - 1);
        }
        return total;
    }

    private int sumOf(int n) {
        return n * (n + 1) / 2;
    }

}
