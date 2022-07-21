package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static ru.job4j.srp.ReportEngine.DATE_FORMAT;

public class ReportAccountingTest {
    @Test
    public void whenGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 150);
        Employee worker2 = new Employee("Georgy", now, now, 220);
        Employee worker3 = new Employee("Alexandra", now, now, 190);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report accounting = new ReportAccounting(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(DATE_FORMAT.format(worker1.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker1.getFired().getTime())).append(";")
                .append(worker1.getSalary() * ReportAccounting.EXCHANGE_RATE).append(" RUB").append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(DATE_FORMAT.format(worker2.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker2.getFired().getTime())).append(";")
                .append(worker2.getSalary() * ReportAccounting.EXCHANGE_RATE).append(" RUB").append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(DATE_FORMAT.format(worker3.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker3.getFired().getTime())).append(";")
                .append(worker3.getSalary() * ReportAccounting.EXCHANGE_RATE).append(" RUB").append(";")
                .append(System.lineSeparator());
        assertThat(accounting.generate(em -> true), is(expected.toString()));
    }
}