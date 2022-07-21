package ru.job4j.srp;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportHR implements Report {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> employees = store.findBy(filter);
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : employees) {
            text.append(employee.getName()).append(";")
                .append(employee.getSalary()).append(";")
                .append(System.lineSeparator());
        }
        return text.toString();
    }
}
