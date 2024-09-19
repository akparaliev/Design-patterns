package CacheImpl;

import java.text.MessageFormat;

import Interfaces.ICache;

public class CacheTimeMeasureDecorator extends CacheDecorator{
    public CacheTimeMeasureDecorator(ICache cache) {
        super(cache);
    }

    @Override
    public Integer get(String key) {
        long startTime = System.nanoTime();
        Integer cacheValue = super.get(key);
        long endTime = System.nanoTime();
        System.out.println(MessageFormat.format("Retrieved value for key: {0} in {1} ms", key, (endTime - startTime) / 1000000.0));

        return cacheValue;
    }
}
