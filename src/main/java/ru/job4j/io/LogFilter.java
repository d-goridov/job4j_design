package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public List<String> filter(String file) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] spl = line.split("\\s");
                if ("404".equals(spl[spl.length - 2])) {
                   rsl.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (String str: log) {
                writer.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        log.forEach(System.out::println);
        save(log, "404.txt");
    }
}
