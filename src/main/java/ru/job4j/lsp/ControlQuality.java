package ru.job4j.lsp;

import java.util.List;

/**
 * Класс осуществляет распределение продуктов
 * в место использования
 * @author Dmitriy Goridov
 * @version 1.0
 */
public class ControlQuality {

   private List<Store> storage;

    public ControlQuality(List<Store> storage) {
        this.storage = storage;
    }

    /**
     * метод распределяет продукты из списка
     * в разные типы хранилищ, в соответствии
     * с условиями
     * @param foodList - список продуктов
     */
    public void allocation(List<Food> foodList) {
        for (Food food: foodList) {
            for (Store store: storage) {
                store.add(food);
            }
        }
    }
}
