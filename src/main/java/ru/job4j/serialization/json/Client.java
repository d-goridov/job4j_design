package ru.job4j.serialization.json;

import java.util.Arrays;

public class Client {
    private String name;
    private int age;
    private boolean hasVisa;
    private String[] wishList;
    private Passport passport;

    public Client(String name, int age, boolean hasVisa, String[] wishList, Passport passport) {
        this.name = name;
        this.age = age;
        this.hasVisa = hasVisa;
        this.wishList = wishList;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isHasVisa() {
        return hasVisa;
    }

    public String[] getWishList() {
        return wishList;
    }

    public Passport getPassport() {
        return passport;
    }

    @Override
    public String toString() {
        return "Client{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", hasVisa=" + hasVisa
                + ", wishList=" + Arrays.toString(wishList)
                + ", passport=" + passport
                + '}';
    }
}
