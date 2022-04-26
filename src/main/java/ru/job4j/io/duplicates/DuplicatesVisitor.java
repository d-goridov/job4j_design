package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;


public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    Map<FileProperty, List<Path>> propertyMap = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        long size = file.toFile().length();
        String name = file.toFile().getName();
        FileProperty fileProperty = new FileProperty(size, name);
        if (propertyMap.containsKey(fileProperty)) {
            propertyMap.get(fileProperty).add(file);
        } else {
            List<Path> list = new ArrayList<>();
            list.add(file);
            propertyMap.put(fileProperty, list);
        }
        return super.visitFile(file, attrs);
    }

    public void showDublicate() {
        for (Map.Entry<FileProperty, List<Path>> entry: propertyMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                for (Path path: entry.getValue()) {
                    System.out.printf("%s : %,d%n ", path.toAbsolutePath(), path.toFile().length());
                }
            }
        }
    }
}
