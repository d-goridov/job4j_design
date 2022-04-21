package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    public boolean isBinary() {
        return findByPredicate(t -> t.children.size() > 2).isEmpty();
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> nodeP = findBy(parent);
        Optional<Node<E>> nodeCh = findBy(child);
        Node<E> newChild = new Node<>(child);
        boolean rsl = nodeP.isPresent() && nodeCh.isEmpty();
        if (rsl) {
            nodeP.get().children.add(newChild);
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(t -> t.value.equals(value));
    }
}
