package ru.job4j.map;

import java.util.*;
import java.util.Map;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", children=" + children
                + ", birthday=" + birthday
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        User user = new User("Dmitriy", 1,
                new GregorianCalendar(1989, Calendar.JUNE, 21));
        User user1 = new User("Dmitriy", 1,
                new GregorianCalendar(1989, Calendar.JUNE, 21));

        Map<User, Object> map = new HashMap<>();
        map.put(user, new Object());
        map.put(user1, new Object());
        for (User user2: map.keySet()) {
            System.out.println(user2.hashCode());
        }
        System.out.println(map);
    }
}
