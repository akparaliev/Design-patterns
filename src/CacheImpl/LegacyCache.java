package CacheImpl;

import java.util.HashMap;
import java.util.Map;

public class LegacyCache<K,V> {
    private final Map<K, V> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void remove(K key) {
        cache.remove(key);
    }

    public void clear() {
        cache.clear();
    }

    public int getSize() {
        return cache.size();
    }

    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }
}
