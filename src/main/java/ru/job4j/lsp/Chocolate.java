package ru.job4j.lsp;

import java.time.LocalDate;

public class Chocolate extends Food {
    public Chocolate(String name, LocalDate expiryDate, LocalDate createDate, double price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
