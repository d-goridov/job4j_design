package ru.job4j.gc;

public class User {
    private String name;
    private char sex;
    private int age;
    public static int count = 0;

    public User(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        count++;
        System.out.println("Объект " + count + " создан");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Объект " + this.age + " удален");
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }
}
