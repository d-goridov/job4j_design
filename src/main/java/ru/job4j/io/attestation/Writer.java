package ru.job4j.io.attestation;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class Writer {

    private Writer() {
    }

    public static void writeFile(String targetFile, List<Path> paths) {
        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(targetFile)))) {
            paths.forEach(file -> writer.write(file.toString() + System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
