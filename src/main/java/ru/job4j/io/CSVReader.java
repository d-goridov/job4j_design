package ru.job4j.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

    public static void handle(ArgsName argsName) {
        Path path = Path.of(argsName.get("path"));
        String delimeter = argsName.get("delimiter");
        String out = argsName.get("out");
        List<String> filter = Arrays.stream(argsName.get("filter").split(",")).toList();
        validation(path, delimeter, out);
        printOut(out, delimeter, path, filter);
    }

    private static void validation(Path path, String delimiter, String out) {
        if (!path.toFile().exists() || !(path.toString().contains(".csv"))) {
            throw new IllegalArgumentException("File at given path does not exist or the extension is incorrect");
        }
        if (!"stdout".equals(out) && !new File(out).isFile()) {
            throw new IllegalArgumentException("Incorrect arg \"out\". "
                    + "If you want print result to console enter \"stdout\"."
                    + "If write to file, enter correct pattern of fail ");

        }
        if (!";".equals(delimiter)) {
            throw new IllegalArgumentException("Delimeter set incorrectly, use \";\" ");
        }
    }

    private static List<Integer> indexOfColumn(Path path, String delimiter, List<String> filter) {
        List<Integer> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(path)) {
            List<String> columns = Arrays.stream(scanner.nextLine().split(delimiter)).toList();
            for (int i = 0; i < columns.size(); i++) {
                if (filter.contains(columns.get(i))) {
                    result.add(i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void printOut(String out, String delimiter, Path path, List<String> filter) {
        String rsl = makeStringData(path, delimiter, indexOfColumn(path, delimiter, filter));
        if ("stdout".equals(out)) {
            System.out.println(rsl);
        } else {
            try (FileWriter dataOut = new FileWriter(out)) {
                dataOut.write(rsl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String makeStringData(Path path, String delimiter, List<Integer> column) {
        StringBuilder data = new StringBuilder();
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                List<String> row = Arrays.stream(scanner.nextLine().split(delimiter)).toList();
                for (Integer number : column) {
                    data.append(row.get(number)).append(delimiter);
                }
                data.deleteCharAt(data.lastIndexOf(";"));
                data.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("Wrong number of args. Please enter four args");
        }
        ArgsName name = ArgsName.of(args);
        handle(name);
    }

}
