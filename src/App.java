import CacheImpl.CacheTypeEnum;
import Interfaces.ICache;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting...");
        //testLFUCache();
        testFIFOCache();
    }

    private static void testLFUCache(){
        ICache cache = CacheFactory.createCacheInstance(CacheTypeEnum.LFU, 3); 
        cache.put("key1", 1); // key1:1,  freq 1 
        cache.put("key1", 6); // key1:6    freq 2
        cache.put("key2", 2); // key1:6, key2:2
        cache.put("key3", 3); // cache: key1:6, key2:2, key3:3
        cache.get("key3"); // get key3

        // Until this line, frequences of keys are: 
        // [key1: 2, key2: 1, key3: 2], , where the 1st element is key, the 2nd is frequence.
        // The next line removes the key with least frequence, it is key2 with frequence = 1.
        cache.put("key4", 10); // cache: key1:6, key3:3, key4:10

        System.out.println(cache.get("key1"));
        System.out.println(cache.get("key3"));
        System.out.println(cache.get("key4"));

        // We should expect here - null and error message.
        System.out.println(cache.get("key2")); 
    }

    private static void testFIFOCache(){
        ICache cache = CacheFactory.createCacheInstance(CacheTypeEnum.FIFO, 3);
        cache.put("key1", 1); // [key1:1, ]
        cache.put("key2", 2); // [key1:1, key2:2, ]
        cache.put("key3", 3); // [key1:1, key2:2, key3:3, ]
        cache.put("key1", 6); // [key2:2, key3:3, key1:6, ]
        cache.put("key2", 5); // [key3:3, key1:6, key2:5, ] cap = 3

        // Until this line, the order of keys in the FIFO cache are: 
        // [key3: 3, key1: 6, key2: 5], where the 1st element is key, the 2nd is value.
        // The next line removes the key that updated/added earlier than other keys -> it is key3.
        cache.put("key4", 10); // [key3:3, key1:6, key2:5, ] remove key3 as it modified earlier than key1 and key2, [key1:6, key2:5, key4:10]

        System.out.println(cache.get("key1"));
        System.out.println(cache.get("key2"));
        System.out.println(cache.get("key4"));

        // We should expect here - null and error message.
        System.out.println(cache.get("key3")); 
    }
}
