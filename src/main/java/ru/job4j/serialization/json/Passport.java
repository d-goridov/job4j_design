package ru.job4j.serialization.json;

public class Passport {
    final private String number;

    public Passport(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Passport{"
                + "number='" + number + '\''
                + '}';
    }
}
