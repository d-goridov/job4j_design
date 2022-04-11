package ru.job4j.generics.store;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;


public class RoleStoreTest {

    @Test
    public void whenAddAndFindThenDescriptionIsActor() {
        RoleStore store = new RoleStore();
        store.add(new Role("2", "Actor"));
        Role result = store.findById("2");
        assertThat(result.getDescription(), is("Actor"));
    }

    @Test
    public void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("3", "Gamer"));
        Role result = store.findById("5");
        assertNull(result);
    }

    @Test
    public void whenReplaceThenDescriptionIsBuilder() {
        RoleStore store = new RoleStore();
        store.add(new Role("3", "Gamer"));
        store.replace("3", new Role("3", "Builder"));
        Role result = store.findById("3");
        assertThat(result.getDescription(), is("Builder"));
    }

    @Test
    public void whenNoReplaceRoleThenNoChangeDescription() {
        RoleStore store = new RoleStore();
        store.add(new Role("7", "Designer"));
        store.replace("10", new Role("10", "Sculptor"));
        Role result = store.findById("7");
        assertThat(result.getDescription(), is("Designer"));
    }

    @Test
    public void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Actress"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteRoleThenDescriptionIsCooker() {
        UserStore store = new UserStore();
        store.add(new User("1", "Cooker"));
        store.delete("10");
        User result = store.findById("1");
        assertThat(result.getUsername(), is("Cooker"));
    }
}