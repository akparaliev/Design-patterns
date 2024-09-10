import java.text.MessageFormat;

import CacheImpl.CacheTypeEnum;
import CacheImpl.LFUCacheBuilder;
import Interfaces.ICache;
import CacheImpl.FIFOCache;

public class CacheFactory {
    public static ICache createCacheInstance(CacheTypeEnum type, int capacity) {
        switch (type) {
            case CacheTypeEnum.FIFO:
                return new FIFOCache(capacity);
            case CacheTypeEnum.LFU:
                LFUCacheBuilder lfuCacheBuilder = new LFUCacheBuilder().setCapacity(capacity).setServerName("localhost:8080");
                return lfuCacheBuilder.build();
            default:
                System.out.println(MessageFormat.format("cache with type {0} is not implemented yet.", type));
                return null;
        }
    }
}
