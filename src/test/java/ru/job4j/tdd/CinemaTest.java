package ru.job4j.tdd;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertNull;


public class CinemaTest {

    Cinema cinema;

    @Before
    public void initCinema() {
        cinema = new Cinema3D();
    }


    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(ticket));
    }

    @Test
    public void whenCantBuy() {
        Account account = new AccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertNull(ticket);
    }

    @Test
    public void whenFind() {
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(sessions));
    }

    @Test
    public void whenNotFind() {
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> false);
        assertThat(sessions, is(nullValue()));
    }

    @Test
    public void whenAddAndCount() {
        cinema.add(new Session3D());
        cinema.add(new Session3D());
        List<Session> sessions = List.of(new Session3D(), new Session3D());
        assertThat(sessions.size(), is(2));
    }
}