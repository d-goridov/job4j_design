package ru.job4j.io.duplicates;

import java.util.Objects;

public class FileProperty {
    private final long size;

    private final String name;

    public FileProperty(long size, String name) {
        this.size = size;
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileProperty that = (FileProperty) o;
        return size == that.size && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, name);
    }
}
