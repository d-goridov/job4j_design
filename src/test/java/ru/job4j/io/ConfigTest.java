package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConfigTest {

    @Test
    public void whenPairWithComment() {
        String path = "app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("hibernate.connection.username"), is("postgres"));

    }

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Yamaha"));
        assertThat(config.value("model"), is("Serow"));

    }

    @Test
    public void whenPairWithCommentsAndNullLine() {
        String path = "./data/pair_with_comment_and_nullLine.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Dmitriy Goridov"));
        assertThat(config.value("department"), is("it"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenPairErrorPattern() {
        String path = "./data/pair_error_pattern.properties";
        Config config = new Config(path);
        config.load();
    }

}