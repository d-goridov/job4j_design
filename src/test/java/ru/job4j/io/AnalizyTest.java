package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenTwoNoWorkDiapason() throws IOException {

        Analizy rsl = new Analizy();
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");

        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        rsl.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(sb::append);
        }
        assertThat(sb.toString(), is("10:57:01;10:59:01;11:01:02;11:02:02;"));

    }

    @Test
    public void whenOneNoWorkDiapason() throws IOException {

        Analizy rsl = new Analizy();
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");

        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("100 10:59:01");
        }
        rsl.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(sb::append);
        }
        assertThat(sb.toString(), is("10:57:01;10:59:01;"));

    }
}