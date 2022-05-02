package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        String userSay;
        String botSay;
        boolean botSleep = false;
        List<String> log = new ArrayList<>();
        List<String> botAnswers = readPhrases();
        Random random = new Random();
        log.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss")));
        System.out.println("Добро пожаловать в чат!");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.print("User: ");
                userSay = reader.readLine();
                log.add(userSay);
                if (STOP.equals(userSay)) {
                    System.out.println("Приостановка работы чата");
                    log.add("Приостановка работы чата");
                    botSleep = true;
                } else if (CONTINUE.equals(userSay)) {
                    System.out.println("Продолжаем работу");
                    log.add("Продолжаем работу");
                    botSleep = false;
                } else if (!botSleep && !OUT.equals(userSay)) {
                    botSay = botAnswers.get(random.nextInt(botAnswers.size()));
                    System.out.println("Pikachu: " + botSay);
                    log.add(botSay);
                }
            } while (!OUT.equals(userSay));
            System.out.println("Пока!");
            log.add("Пока!");
            saveLog(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readPhrases() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            reader.lines().forEach(rsl::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("logChat.txt", "phrase.txt");
        cc.run();
    }
}
