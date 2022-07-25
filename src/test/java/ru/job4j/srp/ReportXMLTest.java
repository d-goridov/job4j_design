package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;
import java.util.TimeZone;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ReportXMLTest {

    @Test
    public void whenXmlGenerated() {
        MemStore store = new MemStore();
        Employee worker1 = new Employee("Ivan",
                new Calendar.Builder()
                        .setCalendarType("iso8601")
                        .setDate(2019, 1, 11)
                        .setTimeOfDay(15, 33, 3, 152)
                        .setTimeZone(TimeZone.getDefault()).build(),
                new Calendar.Builder()
                        .setCalendarType("iso8601")
                        .setDate(2019, 2, 15)
                        .setTimeOfDay(15, 33, 3, 230)
                        .setTimeZone(TimeZone.getDefault()).build(),
                100.5);
        store.add(worker1);
        Report report = new ReportXML(store);
        String ln = "\n";
        StringBuilder expected = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append(ln)
                .append("<employees>").append(ln)
                .append("    <employee>").append(ln)
                .append("        <fired>2019-02-15T15:33:03.230+03:00</fired>").append(ln)
                .append("        <hired>2019-01-11T15:33:03.152+03:00</hired>").append(ln)
                .append("        <name>Ivan</name>").append(ln)
                .append("        <salary>100.5</salary>").append(ln)
                .append("    </employee>").append(ln)
                .append("</employees>").append(ln);
        assertThat(report.generate(employee1 -> true), is(expected.toString()));
    }
}