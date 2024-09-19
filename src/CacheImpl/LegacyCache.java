package CacheImpl;

import java.util.HashMap;
import java.util.Map;

public class LegacyCache {
    private final Map<String, Integer> cache = new HashMap<>();

    public void put(String key, Integer value) {
        cache.put(key, value);
    }

    public Integer get(String key) {
        return cache.get(key);
    }

    public void remove(String key) {
        cache.remove(key);
    }

    public void clear() {
        cache.clear();
    }

    public int getSize() {
        return cache.size();
    }

    public boolean containsKey(String key) {
        return cache.containsKey(key);
    }
}
