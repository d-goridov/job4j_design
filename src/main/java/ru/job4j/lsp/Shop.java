package ru.job4j.lsp;

public class Shop extends AbstractStore {

    private static final int DISCOUNT = 35;

    @Override
    public boolean add(Food food) {
        boolean res = check(food);
        if (check(food)) {
            if (checkForDiscount(food)) {
                food.setDiscount(DISCOUNT);
            }
            list.add(food);
        }
        return res;
    }

    private boolean checkForDiscount(Food food) {
        return FoodCondition.getPercentCondition(food) >= HIGH_PERCENT;
    }

    @Override
    public boolean check(Food food) {
        return FoodCondition.getPercentCondition(food) >= LOW_PERCENT
                && FoodCondition.getPercentCondition(food) < OUT_PERCENT;
    }


}
