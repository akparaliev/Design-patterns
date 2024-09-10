package Interfaces;

// Defines methods for Cache.
public interface ICache {
    void put(String key, Integer value);

    Integer get(String key);

    void remove(String key);

    // optional methods to implement
    void clear();

    int getSize();

    boolean containsKey(String key);
}
