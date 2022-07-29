package ru.job4j.lsp;

public class Warehouse extends AbstractStore {

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
        return condition.getPercentCondition(food) < LOW_PERCENT;
    }
}
