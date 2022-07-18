package ru.job4j.gc.cash;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        SoftReference<V> ref = new SoftReference<>(value);
        cache.put(key, ref);
    }

    public V get(K key) {
        V strong = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (strong == null) {
            strong = this.load(key);
            put(key, strong);
        }
        return strong;
    }

    protected abstract V load(K key);
}
