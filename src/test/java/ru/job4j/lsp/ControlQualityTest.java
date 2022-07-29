package ru.job4j.lsp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ControlQualityTest {

    private Store ware;
    private Store shop;
    private Store trash;
    private ControlQuality quality;
    private LocalDate date = LocalDate.now();

    @Before
    public void initStores() {
        ware = new Warehouse();
        shop = new Shop();
        trash = new Trash();
        quality = new ControlQuality(List.of(ware, shop, trash));
    }

    @Test
    public void whenAddToWare() {
        Food potato = new Potato("Young", date.plusMonths(1),
                (date.minusDays(2)), 50.0, 15);
        List<Food> foods = List.of(potato);
        quality.allocation(foods);
        assertThat(ware.getContent(), is(foods));
    }

    @Test
    public void whenAddToShop() {
        Food choco = new Chocolate("AlpenGold", date.plusDays(12),
                date.minusDays(10), 50.0, 15);
        List<Food> foods = List.of(choco);
        quality.allocation(foods);
        assertThat(shop.getContent(), is(foods));
        Assert.assertEquals(choco.getDiscount(), 15.0, 0.01);
    }

    @Test
    public void whenAddToShopWithDiscount() {
        Food choco = new Chocolate("Milka", date.plusDays(2),
                date.minusDays(25), 50.0, 20);
        List<Food> foods = List.of(choco);
        quality.allocation(foods);
        assertThat(shop.getContent(), is(foods));
        Assert.assertEquals(40.0, choco.getPrice(), 0.01);
    }

    @Test
    public void whenAddToTrash() {
        Food potato = new Potato("Old", date.minusDays(10),
                date.minusDays(24), 50.0, 15);
        List<Food> foods = List.of(potato);
        quality.allocation(foods);
        assertThat(trash.getContent(), is(foods));
    }

    @Test
    public void whenAddManyProducts() {
        Food item1 = new Potato("Free", date.plusDays(30), date.minusDays(2), 62.5, 15);
        Food item2 = new Chocolate("Snickers", date.plusDays(4), date.minusDays(25), 52.6, 33);
        Food item3 = new Chocolate("Mars", date.minusDays(3), date.minusDays(30), 51.5, 21);
        Food item4 = new Chocolate("Bounty", date.plusDays(40), date.minusDays(5), 44.5, 18);
        List<Food> foods = List.of(item1, item2, item3, item4);
        quality.allocation(foods);
        assertThat(ware.getContent(), is(List.of(item1, item4)));
        assertThat(shop.getContent(), is(List.of(item2)));
        Assert.assertEquals(35.25, item2.getPrice(), 0.01);
        assertThat(trash.getContent(), is(List.of(item3)));


    }
}