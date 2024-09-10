package CacheImpl;

public class LFUCacheItem {
    public LFUCacheItem(){}
    public LFUCacheItem(String key, Integer value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }

    // defining Prototype.
    public LFUCacheItem clone() {
        LFUCacheItem clonedCacheItem = new LFUCacheItem();
        clonedCacheItem.setKey(this.key);
        clonedCacheItem.setValue(this.value);
        clonedCacheItem.setFrequency(this.frequency);

        return clonedCacheItem;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key_) {
        this.key = key_;
    }
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    private String key;
    private int frequency;
    private Integer value;
}
