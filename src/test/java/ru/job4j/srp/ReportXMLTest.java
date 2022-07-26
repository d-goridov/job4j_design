package ru.job4j.srp;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ReportXMLTest {

    @Test
    public void whenXmlGenerated() {
        MemStore store = new MemStore();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Calendar hired = new Calendar.Builder()
                .setCalendarType("iso8601")
                .setDate(2019, 1, 11)
                .setTimeOfDay(15, 33, 3, 152)
                .setTimeZone(TimeZone.getDefault()).build();
        Calendar fired = new Calendar.Builder()
                .setCalendarType("iso8601")
                .setDate(2019, 2, 15)
                .setTimeOfDay(15, 33, 3, 230)
                .setTimeZone(TimeZone.getDefault()).build();
        String date1 = formatter.format(hired.getTime());
        String date2 = formatter.format(fired.getTime());
        Employee worker1 = new Employee("Ivan", hired, fired, 100.5);
        store.add(worker1);
        Report report = new ReportXML(store);
        String ln = "\n";
        StringBuilder expected = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append(ln)
                .append("<employees>").append(ln)
                .append("    <employee>").append(ln)
                .append(String.format("        <fired>%s</fired>", date2)).append(ln)
                .append(String.format("        <hired>%s</hired>", date1)).append(ln)
                .append("        <name>Ivan</name>").append(ln)
                .append("        <salary>100.5</salary>").append(ln)
                .append("    </employee>").append(ln)
                .append("</employees>").append(ln);
        assertThat(report.generate(employee1 -> true), is(expected.toString()));
    }
}