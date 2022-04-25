package ru.job4j.io;

import java.io.*;

public class Analizy {

    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {

        String line;
        boolean flag = false;
        while ((line = reader.readLine()) != null) {
            String[] str = line.split("\\s", 2);
            if (isNotWork(str[0]) && !flag) {
                flag = true;
                writer.write(str[1]);
                writer.write(";");
            }
            if (!isNotWork(str[0]) && flag) {
                flag = false;
                writer.write(str[1]);
                writer.write(";");
                writer.println();
            }
        }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isNotWork(String s) {
        return Integer.parseInt(s) == 400 || Integer.parseInt(s) == 500;
    }

    public static void main(String[] args) {
        new Analizy().unavailable("source.csv", "target.csv");
    }
}
