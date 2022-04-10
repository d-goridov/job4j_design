package ru.job4j.generics;

public class Predator extends Animal {
    String name = "predator";

    @Override
    public String toString() {
        return "Predator{"
                + "name='" + name + '\''
                + '}';
    }
}
