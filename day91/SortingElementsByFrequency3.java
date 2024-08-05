import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SortingElementsByFrequency3 {

    static HashMap<Integer, Integer> map;
    static ArrayList<Integer> array;

    public static int[] sortByFrequency(int[] nums) {
        array = new ArrayList<>();
        map = new HashMap<>();
        loadToArray(nums);
        loadArrayToMap(nums);
        Collections.sort(array, (Integer value1, Integer value2) -> {
            int frequencyOne = map.get(value1);
            int frequencyTwo = map.get(value2);
            if (frequencyOne < frequencyTwo) {
                return 1;
            } else if (frequencyOne > frequencyTwo) {
                return -1;
            }
            
            return value1 ;

        });

        return toArray(array);
    }

    private static int[] toArray(ArrayList<Integer> array) {
        int[] tem = new int[array.size()];
        int index = 0;
        for (int item : array) {
            tem[index++] = item;
        }
        return tem;
    }

    private static void loadToArray(int[] nums) {

        for (int index = 0; index < nums.length; index++) {
            array.add(nums[index]);
        }
    }

    private static void loadArrayToMap(int[] nums) {

        for (int index = 0; index < nums.length; index++) {
            if (map.containsKey(nums[index])) {
                map.put(nums[index], map.get(nums[index]) + 1);
            } else {
                map.put(nums[index], 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 2, 8, 5, 6, 8, 8 };
        nums = sortByFrequency(nums);
        System.out.println();
        for (int index = 0; index < nums.length; index++) {
            System.out.println(nums[index]);
        }
    }
}
