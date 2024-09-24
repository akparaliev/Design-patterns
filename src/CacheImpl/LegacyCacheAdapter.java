package CacheImpl;

import java.text.MessageFormat;
import java.util.Iterator;

import Interfaces.ICache;

// We need to adapt it to the case: 
// LegacyCache does not have capacity, 
// so we need to add this contraints here to adapt to our memory limits.
public class LegacyCacheAdapter<K,V> implements ICache<K,V> {
    private LegacyCache<K,V> legacyCache;
    private int capacity;

    public LegacyCacheAdapter(int capacity) {
        legacyCache = new LegacyCache<K,V>();
        this.capacity = capacity;
    }

    @Override
    public void put(K key, V value) {
        if (legacyCache.getSize() >= capacity && !legacyCache.containsKey(key)) {
            System.out.println(MessageFormat.format("It is not possible to add new item {0} to the cache. The size of cache reached the capacity: {1}. Please remove items from cache.", key, capacity));
            return; 
        }

        legacyCache.put(key, value);
        System.out.println(MessageFormat.format("Key: {0} with value: {1} was added/updated to the legacy cache", key, value));
    }

    @Override
    public V get(K key) {
        return legacyCache.get(key);
    }

    @Override
    public void remove(K key) {
        legacyCache.remove(key);
    }

    @Override
    public void clear() {
        legacyCache.clear();
    }

    @Override
    public int getSize() {
        return legacyCache.getSize();
    }

    @Override
    public boolean containsKey(K key) {
        return legacyCache.containsKey(key);
    }

    @Override
    public Iterator<K> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}
