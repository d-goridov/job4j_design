package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public boolean revert() {
        boolean rsl = true;
        if (head != null && head.next != null) {
            Node<T> prev = null;
            Node<T> current = head;
            Node<T> next;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        } else {
            rsl = false;
        }
        return rsl;
    }

    public void addFirst(T value) {
        head = new Node<T>(value, head);
    }

    public T deleteFirst() {
        Node<T> node = head;
        if (node == null) {
           throw new NoSuchElementException();
        }
        Node<T> next = head.next;
        T element = node.value;
        node.value = null;
        node.next = null;
        head = next;
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
