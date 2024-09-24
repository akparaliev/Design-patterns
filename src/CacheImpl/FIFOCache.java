package CacheImpl;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import Interfaces.ICache;

public class FIFOCache<K,V> implements ICache<K,V>{
    private final int capacity;
    private final Map<K, V> dictMap;
    private final LinkedList<K> queue;

    public FIFOCache(int capacity) {
        this.capacity = capacity;
        this.dictMap = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    @Override
    public void put(K key, V value) {
        if (containsKey(key)) {
            dictMap.put(key, value);

            // update the order of the key from queue
            queue.remove(key);
            queue.addLast(key);
        } else {
            while (getSize() >= capacity) {
                // remove the oldest element from queue and cache.
                K oldestItemKey = queue.removeFirst();
                dictMap.remove(oldestItemKey);
            }

            dictMap.put(key, value);
            queue.addLast(key);
        }
    }

    @Override
    public V get(K key) {
        if (containsKey(key)){
            return dictMap.get(key);
        }

        System.out.println(MessageFormat.format("ERROR: Key {0} is not in cache.", key));
        return null;
    }

    @Override
    public void remove(K key) {
        if (containsKey(key)) {
            dictMap.remove(key);
            queue.remove(key);
        } else {
            System.out.println(MessageFormat.format("ERROR: Key {0} is not in cache.", key));
        }
    }

    @Override
    public void clear() {
        dictMap.clear();
        queue.clear();
    }

    @Override
    public int getSize() {
        return dictMap.size();
    }

    @Override
    public boolean containsKey(K key) {
        return dictMap.containsKey(key);
    }

    @Override
    public Iterator<K> iterator() {
        //return queue.iterator();
        return queue.iterator();
    }
}
