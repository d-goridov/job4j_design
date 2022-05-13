package ru.job4j.io.attestation;

import ru.job4j.io.ArgsName;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validate {

    static String ln = System.lineSeparator();
    static String wrongType =  "Incorrect type search - " + ln
            + "Choose : " + ln
            + "mask - search to mask" + ln
            + "regex - search to regex" + ln
            + "name- search to name of file" + ln;

    private Validate() {
    }

    public static Path checkArgs(ArgsName argsName) {
        Path path = Path.of(argsName.get("d"));
        String type = argsName.get("t");
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path it's not a directory");
        }
        if (!("mask".equals(type) || "regex".equals(type) || "name".equals(type))) {
            throw new IllegalArgumentException(wrongType);
        }
        return path;
    }
}
