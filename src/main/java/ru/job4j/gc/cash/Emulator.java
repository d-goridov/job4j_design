package ru.job4j.gc.cash;

import java.util.Scanner;

public class Emulator {
    private final Scanner scanner = new Scanner(System.in);
    private DirFileCache dirFileCache;
    private static final int SET_DIR = 1;
    private static final int ADD_TO_CASH = 2;
    private static final int GET_TEXT = 3;
    private static final int EXIT = 4;
    private static final String MENU = """
         Выберите действие:
         1. Установить директорию
         2. Добавить файл в кэш
         3. Получить содержимое файла
         4. Выход
         """;

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
        System.out.println(dirFileCache.get(key));
    }

    private void start() {
        int choice = -1;
        while (choice != 4) {
            System.out.println(MENU);
            choice = scanner.nextInt();
            switch (choice) {
                case SET_DIR -> setDir();
                case ADD_TO_CASH -> putToCash();
                case GET_TEXT -> getText();
                case EXIT -> System.out.println("Выход");
                default -> System.out.println("Некорректный выбор");
            }
        }
    }

    public static void main(String[] args) {
        Emulator emulator = new Emulator();
        emulator.start();
    }
}
