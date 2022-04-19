package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int size = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    /**
     * метод добавляет элемент в мапу
     * и расширяет при необходимости
     * @param key - ключ
     * @param value - значение
     * @return true - размер увеличился, false - остался прежним.
     */
    @Override
    public boolean put(K key, V value) {
        if (size >= (table.length * LOAD_FACTOR)) {
            expand();
        }
        int index = indexFor(hash(key));
        MapEntry<K, V> entry = new MapEntry<>(key, value);
        boolean rsl = false;
        if (table[index] == null) {
            table[index] = entry;
            rsl = true;
            size++;
            modCount++;
        }
        return rsl;
    }

    /**
     * метод позволяет узнать количество элементов мапы
     * @return - значение размера
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @param key ключ пары
     * @return хеш ключа
     */
    private int hash(K key) {
        return (key == null) ? 0 : key.hashCode() ^ (key.hashCode() >>> 16);
    }

    /**
     * метод определяет индекс бакета
     *
     * @param hash - хеш ключа
     * @return индекс бакета по которому располагается пара
     */
    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    /**
     * метод производит расширение вместимости в 2 раза
     */
    private void expand() {
        capacity *= 2;
        table = new MapEntry[capacity];
        for (MapEntry<K, V> element : table) {
            if (element != null) {
                put(element.key, element.value);
            }
        }
    }

    /**
     * метод получения значения по ключу
     * @param key - ключ пары
     * @return - значение
     */
    @Override
    public V get(K key) {
        V rsl = null;
        int index = indexFor(hash(key));
        if ((table[index] != null) && (table[index].key.equals(key))) {
            rsl = table[index].value;
        }
        return rsl;
    }

    /**
     * метод удаления пары по ключу
     * @param key - ключ пары
     * @return true - если удаление успешное, false - в противном случае
     */
    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int index = indexFor(hash(key));
        if (table[index].key.equals(key)) {
            table[index] = null;
            size--;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            final int expectedModCount = modCount;
            int cursor = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (cursor < table.length - 1 && table[cursor] == null) {
                     cursor++;
                }
                return table[cursor] != null;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[cursor++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
}
