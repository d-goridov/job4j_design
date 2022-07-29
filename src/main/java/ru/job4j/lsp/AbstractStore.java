package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс выполняет функцию шаблона
 * для конкретных реализаций хранилищ
 * с конкретным базовым состоянием и
 * поведением
 * @author Dmitriy Goridov
 * @version 1.0
 */
public abstract class AbstractStore implements Store {

    protected final List<Food> list = new ArrayList<>();
    protected FoodCondition condition = new FoodCondition();

    public List<Food> getContent() {
        return new ArrayList<>(list);
    }
}
