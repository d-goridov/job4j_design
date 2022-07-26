package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReportJSONTest {

    @Test
    public void whenJsonGenerated() {
        MemStore store = new MemStore();
        Employee worker1 = new Employee("Ivan",
                new Calendar.Builder()
                        .setCalendarType("iso8601")
                        .setDate(2020, 1, 11)
                        .setTimeOfDay(15, 33, 21)
                        .build(),
                new Calendar.Builder()
                        .setCalendarType("iso8601")
                        .setDate(2021, 2, 15)
                        .setTimeOfDay(10, 22, 31)
                        .build(),
                100.5);
        store.add(worker1);
        Report report = new ReportJSON(store);
        StringBuilder expected = new StringBuilder()
                .append("[{")
                .append("\"name\":\"Ivan\",")
                .append("\"hired\":")
                .append("{\"year\":2020,\"month\":1,\"dayOfMonth\":11,\"hourOfDay\":15,\"minute\":33,\"second\":21},")
                .append("\"fired\":")
                .append("{\"year\":2021,\"month\":2,\"dayOfMonth\":15,\"hourOfDay\":10,\"minute\":22,\"second\":31},")
                .append("\"salary\":100.5")
                .append("}]");
        assertThat(report.generate(employee1 -> true), is(expected.toString()));
    }
}