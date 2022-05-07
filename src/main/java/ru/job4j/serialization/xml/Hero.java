package ru.job4j.serialization.xml;

public class Hero {
    String name;

    public Hero(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "Hero{"
                + "name='" + name + '\''
                + '}';
    }
}
