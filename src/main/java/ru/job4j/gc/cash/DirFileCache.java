package ru.job4j.gc.cash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {

        this.cachingDir = cachingDir;
    }

    public String getCachingDir() {
        return cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(key))) {
            reader.lines().forEach(line -> result.append(line).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }


}
