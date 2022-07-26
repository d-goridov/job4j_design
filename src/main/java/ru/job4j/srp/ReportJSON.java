package ru.job4j.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportJSON implements Report {

    private Store store;
    private Gson gson;

    public ReportJSON(Store store) {
        this.store = store;
        gson = new GsonBuilder().create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {

        return gson.toJson(store.findBy(filter));
    }

    public static void main(String[] args) {
        Employee employee = new Employee("peter", Calendar.getInstance(), Calendar.getInstance(), 210.3);
        Store store = new MemStore();
        store.add(employee);
        Report report = new ReportJSON(store);
        System.out.println(report.generate(employee2 -> true));
    }
}
