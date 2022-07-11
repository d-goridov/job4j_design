package ru.job4j.kiss;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class MaxMinTest {

    private MaxMin rsl;

    @Before
    public void initObject() {
        rsl = new MaxMin();
    }

    @Test
    public void whenFindMaxValue() {
        List<String> list = List.of("ADC", "ACD", "ABX", "AES");
        String expected = rsl.max(list, Comparator.naturalOrder());
        assertThat(expected, is("AES"));
    }


    @Test
    public void whenFindMinValue() {
        List<String> list = List.of("ADC", "ACD", "ABX", "AES");
        String expected = rsl.max(list, Comparator.reverseOrder());
        assertThat(expected, is("ABX"));
    }
}