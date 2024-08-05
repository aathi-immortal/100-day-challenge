import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Item {
    public int value;
    public int frequency;

    public Item(int value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Item [value=" + value + ", frequency=" + frequency + "]";
    }

}

public class SortingElementsByFrequency2 {

    static int[] map;
    static ArrayList<Item> items;

    public static int[] sortByFrequency(int[] nums) {

        items = new ArrayList<>();
        map = new int[10000000];
        loadNumsToMap(nums);
        loadMapToList(nums);
        Collections.sort(items, (Item item1, Item item2) -> -1 * (item1.frequency > item2.frequency ? 1
                : item1.frequency < item2.frequency ? -1 : 0));
        return toArray(items, nums.length);
    }

    private static int[] toArray(ArrayList<Item> items, int size) {
        int[] itemArray = new int[size];
        int index = 0;
        for (Item item : items) {
            for (int time = 0; time < item.frequency; time++)
                itemArray[index++] = item.value;
        }
        return itemArray;
    }

    private static void loadMapToList(int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            int currentItemFrequency = map[nums[index]];
            if (currentItemFrequency != 0)
                items.add(new Item(nums[index], currentItemFrequency));
        }
    }

    private static void loadNumsToMap(int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            int currentItem = nums[index];
            map[currentItem] += 1;
        }
    }

}
