package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenGetValue() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(5, "Honda");
        assertThat(map.get(5), is("Honda"));
    }

    @Test
    public void whenPutAndGetTwoElements() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(5, "Honda");
        map.put(3, "Kawasaki");
        assertThat(map.get(5), is("Honda"));
        assertThat(map.get(3), is("Kawasaki"));
    }

    @Test
    public void whenCheckSizeAndChangedElement() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(5, "Honda");
        map.put(5, "Yamaha");
        assertThat(map.getSize(), is(1));
        assertThat(map.get(5), is("Yamaha"));
    }

    @Test
    public void whenRemoveElement() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(3, "Honda");
        map.put(5, "Yamaha");
        assertThat(map.getSize(), is(2));
        map.remove(5);
        assertThat(map.getSize(), is(1));
        assertNull(map.get(5));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetIteratorFromEmptyMapThenNextThrowException() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        Iterator<Integer> it = map.iterator();
        it.next();
    }

    @Test
    public void whenGetIteratorTwice() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(3, "Honda");
        map.put(5, "Yamaha");
        Iterator<Integer> it = map.iterator();
        assertNotNull(it.next());
        assertNotNull(it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void whenCheckIterator() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Honda");
        map.put(4, "Yamaha");
        map.put(3, "Ducati");
        Iterator<Integer> it = map.iterator();
        assertTrue(it.hasNext());
        assertNotNull(it.next());
        assertTrue(it.hasNext());
        assertNotNull(it.next());
        assertTrue(it.hasNext());
        assertNotNull(it.next());
        assertFalse(it.hasNext());
    }

}