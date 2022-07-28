package ru.job4j.lsp;

public class Warehouse extends AbstractStore {

    private static final int MIN_PERCENT = 25;


    @Override
    public boolean add(Food food) {
        boolean res = check(food);
        if (res) {
            list.add(food);
        }
        return res;
    }

    @Override
    public boolean check(Food food) {
        return FoodCondition.getPercentCondition(food) < MIN_PERCENT;
    }
}
