package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "hero")
public class Hero {

    @XmlAttribute
    String name;

    public Hero() {
    }

    public Hero(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "Hero{"
                + "name='" + name + '\''
                + '}';
    }
}
