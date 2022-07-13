package ru.job4j.tdd;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;


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
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(nullValue()));
    }

    @Test
    public void whenFind() {
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(nullValue()));
    }


    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidPlace() {
        Account account = new AccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, -10, 1, date);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidDate() {
        Account account = new AccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2020, 12, 43, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenBuySoldPlace() {
        Account account = new AccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        Ticket ticket2 = cinema.buy(account, 1, 1, date);
    }
}