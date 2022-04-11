package ru.job4j.generics.store;

import java.util.HashMap;
import java.util.Map;

public class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> storage = new HashMap<>();


    @Override
    public void add(T model) {
        storage.putIfAbsent(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        return storage.replace(model.getId(), model) != null;
    }

    @Override
    public boolean delete(String id) {
        return storage.keySet().removeIf(s -> storage.containsKey(id));
    }

    @Override
    public T findById(String id) {
        return storage.getOrDefault(id, null);
    }
}
