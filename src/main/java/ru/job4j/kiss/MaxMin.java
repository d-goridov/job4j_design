package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return getElement(value, comparator, integer -> integer < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return getElement(value, comparator, integer -> integer > 0);
    }

    private <T> T getElement(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        if (value.isEmpty()) {
            return null;
        }
        T rsl = value.get(0);
        for (T element: value) {
            if (predicate.test(comparator.compare(rsl, element))) {
                rsl = element;
            }
        }
        return rsl;
    }
}
