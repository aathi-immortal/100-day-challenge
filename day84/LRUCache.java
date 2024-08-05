import java.util.HashMap;

public class LRUCache {
    public HashMap<Integer, Integer> cache;

    LRUCache(int capacity) {
        // Write your code here
        cache = new HashMap<>(capacity);

    }

    public int get(int key) {
        // Write your code here
        if (cache.containsKey(key))
            return cache.get(key);
        return -1;
    }

    public void put(int key, int value) {

        cache.put(key, value);

    }
}
