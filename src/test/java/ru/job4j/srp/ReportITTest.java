package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static ru.job4j.srp.ReportEngine.DATE_FORMAT;

public class ReportITTest {
    @Test
    public void whenGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Olga", now, now, 130);
        Employee worker3 = new Employee("Nikolay", now, now, 210);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report prog = new ReportIT(store);
        String ln = System.lineSeparator();
        StringBuilder expected = new StringBuilder()
                .append("<!DOCTYPE html>").append(ln)
                .append("<html lang=\"en\">").append(ln)
                .append("<head>").append(ln)
                .append("<meta charset=\"UTF-8\">").append(ln)
                .append("<title>Employee</title>").append(ln)
                .append("</head>").append(ln)
                .append("<body>").append(ln)
                .append("Name; Hired; Fired; Salary;").append(ln)
                .append(worker1.getName()).append(";")
                .append(DATE_FORMAT.format(worker1.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker1.getFired().getTime())).append(";")
                .append(worker1.getSalary()).append(";")
                .append(ln)
                .append(worker2.getName()).append(";")
                .append(DATE_FORMAT.format(worker2.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker2.getFired().getTime())).append(";")
                .append(worker2.getSalary()).append(";")
                .append(ln)
                .append(worker3.getName()).append(";")
                .append(DATE_FORMAT.format(worker3.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker3.getFired().getTime())).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("</body>").append(ln)
                .append("</html>");
        assertThat(prog.generate(em -> true), is(expected.toString()));
    }

}