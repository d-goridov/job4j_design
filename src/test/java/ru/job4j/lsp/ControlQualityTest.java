package ru.job4j.lsp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ControlQualityTest {

    private static final int DISCOUNT = 35;
    private static final int NON_DISCOUNT = 15;
    Store ware;
    Store shop;
    Store trash;
    ControlQuality quality;

    @Before
    public void initStores() {
        ware = new Warehouse();
        shop = new Shop();
        trash = new Trash();
        quality = new ControlQuality(List.of(ware, shop, trash));
    }

    @Test
    public void whenAddToWare() {
        Food potato = new Potato("Young", LocalDate.of(2022, 8, 30),
                LocalDate.of(2022, 7, 27), 50.0, 15);
        List<Food> foods = List.of(potato);
        quality.allocation(foods);
        assertEquals(potato, ware.getContent().get(0));
    }

    @Test
    public void whenAddToShop() {
        Food choco = new Chocolate("AlpenGold", LocalDate.of(2022, 8, 10),
                LocalDate.of(2022, 7, 19), 50.0, 15);
        List<Food> foods = List.of(choco);
        quality.allocation(foods);
        assertEquals(choco, shop.getContent().get(0));
        Assert.assertEquals(choco.getDiscount(), NON_DISCOUNT);
    }

    @Test
    public void whenAddToShopWithDiscount() {
        Food choco = new Chocolate("Milka", LocalDate.of(2022, 7, 29),
                LocalDate.of(2022, 7, 5), 50.0, 15);
        List<Food> foods = List.of(choco);
        quality.allocation(foods);
        assertEquals(choco, shop.getContent().get(0));
        Assert.assertEquals(choco.getDiscount(), DISCOUNT);
    }

    @Test
    public void whenAddToTrash() {
        Food potato = new Potato("Old", LocalDate.of(2022, 7, 19),
                LocalDate.of(2022, 7, 5), 50.0, 15);
        List<Food> foods = List.of(potato);
        quality.allocation(foods);
        assertEquals(potato, trash.getContent().get(0));
    }
}