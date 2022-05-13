package ru.job4j.io.attestation;

import ru.job4j.io.ArgsName;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Finder finder = new Finder();
        finder.start(ArgsName.of(args));
    }
}
