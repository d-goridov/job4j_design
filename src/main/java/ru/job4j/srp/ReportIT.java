package ru.job4j.srp;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class ReportIT implements Report {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    private Store store;

    public ReportIT(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String ln = System.lineSeparator();
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE html>").append(ln)
                .append("<html lang=\"en\">").append(ln)
                .append("<head>").append(ln)
                .append("<meta charset=\"UTF-8\">").append(ln)
                .append("<title>Employee</title>").append(ln)
                .append("</head>").append(ln)
                .append("<body>").append(ln)
                .append("Name; Hired; Fired; Salary;")
                .append(ln);
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(ln);
        }
        text.append("</body>").append(ln)
            .append("</html>");
        return text.toString();
    }
}
