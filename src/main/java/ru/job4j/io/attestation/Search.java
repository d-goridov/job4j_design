package ru.job4j.io.attestation;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class Search extends SimpleFileVisitor<Path> {
    private Predicate<Path> condition;
    private List<Path> listFiles = new ArrayList<>();

    public Search(Predicate<Path> condition) {
        this.condition = condition;
    }

    public List<Path> getListFiles() {
        return listFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (condition.test(file)) {
           listFiles.add(file);
        }
        return super.visitFile(file, attrs);
    }
}
