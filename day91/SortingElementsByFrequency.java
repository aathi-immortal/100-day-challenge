import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import songutil.Utility;

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

public class SortingElementsByFrequency {
    public static int[] sortByFrequency(int[] nums) {

        ArrayList<Item> items = new ArrayList<>();
        Arrays.sort(nums);
        loadItems(nums, items);
        Collections.sort(items, (Item item1, Item item2) -> -1 * (item1.frequency > item2.frequency ? 1
                : (item1.frequency < item2.frequency ? -1 : 0)));
        // Utility.printItems(items);
        return toArray(items);

    }

    private static int[] toArray(ArrayList<Item> items) {
        int[] itemArray = new int[items.size()];
        int index = 0;
        for (Item item : items) {
            itemArray[index++] = item.value;
        }
        return itemArray;
    }

    private static void loadItems(int[] array, ArrayList<Item> items) {
        int index = 0;
        int previousItem = array[0];
        int count = 0;
        for (; index < array.length; index++) {
            int currentItem = array[index];
            if (previousItem != currentItem) {
                items.add(new Item(previousItem, count));
                count = 0;
                previousItem = currentItem;
            }
            count += 1;

        }
        items.add(new Item(previousItem, count));
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 2, 8, 5, 6, 8, 8 };
        sortByFrequency(nums);
    }
}
