package CacheImpl;

public class LFUCacheBuilder {
    private LFUCache lfuCache;

    public LFUCacheBuilder() {
        lfuCache = new LFUCache();
    }

    public LFUCacheBuilder setCapacity(int capacity) {
        lfuCache.setCapacity(capacity);
        return this;
    }

    public LFUCacheBuilder setServerName(String serverName) {
        lfuCache.setServerName(serverName);
        return this;
    } 

    public LFUCache build() {
        return lfuCache;
    }
}
