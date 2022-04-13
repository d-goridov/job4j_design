package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount = 0;

    private int count = 0;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    private void grow() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
            grow();
        }
        container[count++] = value;
        size += 1;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        if (Objects.checkIndex(index, container.length) != index) {
            throw new IndexOutOfBoundsException();
        }
        T rsl = container[index];
        container[index] = newValue;
        return rsl;
    }

    @Override
    public T remove(int index) {
        if (Objects.checkIndex(index, container.length) != index) {
            throw new IndexOutOfBoundsException();
        }
        T rsl = container[index];
        System.arraycopy(container, index + 1,
                container, index, container.length - index - 1);
        container[container.length - 1] = null;
        size--;
        count--;
        modCount++;
        return rsl;
    }

    @Override
    public T get(int index) {
        if (Objects.checkIndex(index, container.length) != index) {
            throw new IndexOutOfBoundsException();
        }
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        final int expectedModCount = modCount;

        return new Iterator<T>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[cursor++];
            }

        };
    }
}
