package CacheImpl;

public class LFUCacheItem<K,V> {
    public LFUCacheItem(){}
    public LFUCacheItem(K key, V value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }

    // defining Prototype.
    public LFUCacheItem<K,V> clone() {
        LFUCacheItem<K,V> clonedCacheItem = new LFUCacheItem<K,V>();
        clonedCacheItem.setKey(this.key);
        clonedCacheItem.setValue(this.value);
        clonedCacheItem.setFrequency(this.frequency);

        return clonedCacheItem;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key_) {
        this.key = key_;
    }
    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    private K key;
    private int frequency;
    private V value;
}
