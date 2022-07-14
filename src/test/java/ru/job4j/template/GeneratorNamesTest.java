package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;



public class GeneratorNamesTest {

    @Ignore
    @Test
    public void whenGoodGenerate() {
        Generator generator = new GeneratorNames();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        assertThat("I am a Petr Arsentev, Who are you?", is(generator.produce(template, args)));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenWrongKey() {
        Generator generator = new GeneratorNames();
        String template = "I am a ${name}, my age is {age}";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Dmitriy");
        args.put("surname", "Goridov");
        assertThat("I am a Dmitriy, my age is 33", is(generator.produce(template, args)));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenMoreKeys() {
        Generator generator = new GeneratorNames();
        String template = "I am a ${name}, I have a ${pet}";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Dmitriy");
        args.put("pet", "dog");
        args.put("age", "33");
        assertThat("I am a Dmitriy, I have a dog", is(generator.produce(template, args)));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenKeyIsNull() {
        Generator generator = new GeneratorNames();
        String template = "I am a ${name}, I have a ${pet}";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Dmitriy");
        assertThat("I am a Dmitriy, I have a dog", is(generator.produce(template, args)));
    }

}