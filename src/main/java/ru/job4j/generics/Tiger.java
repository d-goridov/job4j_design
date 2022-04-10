package ru.job4j.generics;

public class Tiger extends Predator {
    String name = "tiger";

    @Override
    public String toString() {
        return "Tiger{"
                + "name='" + name + '\''
                + '}';
    }
}
