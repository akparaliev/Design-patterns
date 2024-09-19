package CacheImpl;

import Interfaces.ICache;

public class CacheDecorator implements ICache {
    private final ICache cache;
    public CacheDecorator(ICache cache) {
        this.cache = cache;
    }
    
    public Integer get(String key) {
        return cache.get(key);
    }

    @Override
    public void put(String key, Integer value) {
        cache.put(key, value);
    }

    @Override
    public void remove(String key) {
        cache.remove(key);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public int getSize() {
        return cache.getSize();
    }

    @Override
    public boolean containsKey(String key) {
        return cache.containsKey(key);
    }
    
}
