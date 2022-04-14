package ru.job4j.linkedlist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class SimpleLinkedList<E> implements List<E> {

    Node<E> first;
    Node<E> last;
    int size = 0;
    int modCount = 0;

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(E element) {
            this.element = element;
        }
    }

    @Override
    public void add(E value) {
        Node<E> rsl = new Node<>(value);
        if (first == null) {
            first = rsl;
        } else {
            last.next = rsl;
            rsl.prev = last;
        }
        last = rsl;
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        int i = -1;
        Node<E> start = first;
        while (start != null) {
            i++;
            if (i == index) {
                return start.element;
            }
            start = start.next;
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<>() {
            final int expectedModCount = modCount;
            Node<E> start = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return start != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E rsl = start.element;
                start = start.next;
                return rsl;
            }

        };
    }
}
