package ru.job4j.it;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;



public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenAddAfterMiddle() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 4, 5));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3, 4, 5)));
    }

    @Test
    public void whenRemoveEvenNumber() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListUtils.removeIf(input, s -> s % 2 == 0);
        assertThat(input, is(Arrays.asList(1, 3, 5)));
    }

    @Test
    public void whenReplaceOddNumber() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListUtils.replaceIf(input, s -> s % 2 == 0, 0);
        assertThat(input, is(Arrays.asList(1, 0, 3, 0, 5, 0)));
    }

    @Test
    public void whenRemoveAllEqualsToAnotherList() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> another = new ArrayList<>(Arrays.asList(1, 3, 4));
        ListUtils.removeAll(input, another);
        assertThat(input, is(Arrays.asList(2, 5, 6)));
    }
}