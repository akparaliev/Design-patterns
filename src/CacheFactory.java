import java.text.MessageFormat;

import CacheImpl.CacheTypeEnum;
import CacheImpl.LFUCacheBuilder;
import Interfaces.ICache;
import CacheImpl.FIFOCache;

public class CacheFactory<K,V> {
    public ICache<K,V> createCacheInstance(CacheTypeEnum type, int capacity) {
        switch (type) {
            case CacheTypeEnum.FIFO:
                return new FIFOCache<K,V>(capacity);
            case CacheTypeEnum.LFU:
                LFUCacheBuilder<K,V> lfuCacheBuilder = new LFUCacheBuilder<K,V>().setCapacity(capacity).setServerName("localhost:8080");
                return lfuCacheBuilder.build();
            default:
                System.out.println(MessageFormat.format("cache with type {0} is not implemented yet.", type));
                return null;
        }
    }
}
