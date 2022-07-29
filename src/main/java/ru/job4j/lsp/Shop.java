package ru.job4j.lsp;

public class Shop extends AbstractStore {

    @Override
    public boolean add(Food food) {
        boolean res = check(food);
        if (check(food)) {
            if (checkForDiscount(food)) {
                food.setNewPriceWithDiscount();
            }
            list.add(food);
        }
        return res;
    }

    private boolean checkForDiscount(Food food) {
        return condition.getPercentCondition(food) >= HIGH_PERCENT;
    }

    @Override
    public boolean check(Food food) {
        return condition.getPercentCondition(food) >= LOW_PERCENT
                && condition.getPercentCondition(food) < OUT_PERCENT;
    }


}
