package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;


public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException();
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String s: args) {
            String[] array = validate(s);
            values.put(array[0], array[1]);
        }
    }

    private String[] validate(String string) {
        if (!string.startsWith("-") || !string.contains("=")) {
            throw new IllegalArgumentException();
        }
        String[] array = string.split("=", 2);
        if (array[0].isEmpty() || array[1].isEmpty()) {
            throw new IllegalArgumentException();
        }
        array[0] = array[0].replace("-", "");
        return array;
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
