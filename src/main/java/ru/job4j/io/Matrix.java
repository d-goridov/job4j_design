package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[7][7];
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = (i + 1) * (j + 1);
                    int k = matrix[i][j];
                    String str = Integer.toString(k);
                    out.write(str.getBytes());
                    out.write("\t".getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
