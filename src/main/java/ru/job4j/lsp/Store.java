package ru.job4j.lsp;

import java.util.List;

public interface Store {
    int OUT_PERCENT = 100;
    int HIGH_PERCENT = 75;
    int LOW_PERCENT = 25;

    boolean add(Food food);

    List<Food> getContent();

    boolean check(Food food);
}
