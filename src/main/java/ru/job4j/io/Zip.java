package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    /**
     * Метод архивирует список файлов
     * @param sources - список файлов для архивирования
     * @param target - файл в который помещается архивированные файлы
     */
    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file: sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод производит валидаию аргументов командной строки
     * @param args - массив аргументов командной строки
     * @return - массив значений аргументов
     * архивируемая директория, исключаемые файлы - расширение, конечная директория.
     */
    private static String[] validate(String[]args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Wrong number arguments");
        }
        ArgsName names = ArgsName.of(args);
        if (!Files.isDirectory(Path.of(names.get("d")))) {
            throw new IllegalArgumentException("This directory not exist");
        }
        if (!names.get("e").startsWith(".")) {
            throw new IllegalArgumentException("Wrong filetype extension");
        }
        return new String[]{names.get("d"), names.get("e"), names.get("o")};
    }

    /**
     * Метод возвращает список файлов для архивирования
     * @param path - путь к файлу
     * @param extension - расширение, файлы с которым не подлежат архивации
     * @return - список файлов для архивирования
     */
    public static List<File> getListFiles(String path, String extension) throws IOException {
         return Search.search(Path.of(path), f -> !f.toFile().getName().endsWith(extension))
                 .stream()
                 .map(Path::toFile)
                 .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        String[] array = validate(args);
        List<File> list = getListFiles(String.valueOf(Path.of(array[0])), array[1]);
        zip.packFiles(list, Path.of(array[2]).toFile());
    }
}
