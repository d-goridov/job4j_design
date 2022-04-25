package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
             String line;
             while ((line = reader.readLine()) != null) {
                 if (line.contains("=") && !line.startsWith("#")) {
                     String[] str = line.split("=", 2);
                     String key = str[0];
                     String value = str[1];
                     if (key.isEmpty() || value.isEmpty()) {
                         throw new IllegalArgumentException("String doesn't match pattern \"key - value\"");
                     }
                     values.put(key, value);
                 }
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
         System.out.println(new Config("app.properties"));

    }
}
