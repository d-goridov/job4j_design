package ru.job4j.generics.store;

public class Role extends Base {

    private final String description;

    public Role(String id, String description) {
        super(id);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
