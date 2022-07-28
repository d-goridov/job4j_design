package ru.job4j.lsp;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Класс рассчитыает состояние свежести продукта
 * с даты его производства
 * @author Dmitriy Goridov
 * @version 1.0
 */
public class FoodCondition {

    private static LocalDate currentDate = LocalDate.now();

    /**
     * метод считает срок годности в днях
     * @param food - целевой объект для вычисления
     * @return - количество дней
     */
    private static double diffCreateExpiryDate(Food food) {
        return (double) DAYS.between(food.createDate, food.expiryDate);

    }

    /**
     * метод считает количество дней, которое
     * прошло с начала производства.
     * @param food - целевой объект для вычисления
     * @return - количество дней
     */
    private static double diffCreateCurrentDate(Food food) {
        return (double) DAYS.between(food.createDate, currentDate);
    }

    /**
     * метод рассчитывает процент срока годности,
     * который уже израсходован с начала производства.
     * @param food - целевой объект для вычисления
     * @return - количество процентов
     */
    public static double getPercentCondition(Food food) {
        return (diffCreateCurrentDate(food) / diffCreateExpiryDate(food)) * 100;
    }

}
