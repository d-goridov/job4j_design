package ru.job4j.io.attestation;

import ru.job4j.io.ArgsName;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Finder {

    public void start(ArgsName argsName) throws IOException {
        Path path = Validate.checkArgs(argsName);
        String outFile = argsName.get("o");
        Writer.writeFile(outFile, getListFiles(path, getCondition(argsName)));
    }


    private List<Path> getListFiles(Path root, Predicate<Path> condition) throws IOException {
        Search search = new Search(condition);
        Files.walkFileTree(root, search);
        return search.getListFiles();
    }

    private Predicate<Path> getCondition(ArgsName argsName) {
        String type = argsName.get("t");
        String fileName = argsName.get("n");
        Predicate<Path> condition = null;
        Pattern pattern;
        if ("name".equals(type)) {
            condition = path -> path.toFile().getName().equals(fileName);
        } else if ("mask".equals(type)) {
            String mask = fileName
                    .replace(".", "[.]")
                    .replace("*", "\\w+")
                    .replace("?", "\\w");
            pattern = Pattern.compile(mask);
            condition = path -> path.toFile().getName().matches(pattern.toString());
        } else if ("regex".equals(type)) {
            pattern = Pattern.compile(fileName);
            condition = path -> path.toFile().getName().matches(pattern.toString());
        }
        return condition;
    }
}
