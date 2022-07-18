package ru.job4j.gc.cash;

import java.util.Scanner;

public class Emulator {
    private final Scanner scanner = new Scanner(System.in);
    private DirFileCache dirFileCache;
    private final String menu = "Выберите действие: " + System.lineSeparator()
        + "1. Установить директорию" + System.lineSeparator()
        + "2. Добавить файл в кэш" + System.lineSeparator()
        + "3. Получить содержимое файла" + System.lineSeparator()
        + "4. Выход" + System.lineSeparator();

    private void setDir() {
        System.out.println("Укажите директорию");
        dirFileCache = new DirFileCache(scanner.next());
        System.out.println("Установлена директория " + dirFileCache);
    }

    private void putToCash() {
        System.out.println("Укажите файл для добавления в кэш");
        String key = scanner.next();
        dirFileCache.put(key, dirFileCache.get(key));
    }

    private void getText() {
        System.out.println("Укажите файл");
        String key = scanner.next();
        System.out.println(dirFileCache.load(key));
    }

    private void start() {
        int choice = -1;
        while (choice != 4) {
            System.out.println(menu);
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> setDir();
                case 2 -> putToCash();
                case 3 -> getText();
                case 4 -> System.out.println("Выход");
                default -> System.out.println("Некорректный выбор");
            }
        }
    }

    public static void main(String[] args) {
        Emulator emulator = new Emulator();
        emulator.start();
    }
}
