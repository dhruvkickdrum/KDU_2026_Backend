package com.dhruv.audit;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeProcessor {

    public static List<Employee> filterEmployee (List<Employee> employees, Predicate<Employee> criteria) {
        return employees.stream()
                .filter(criteria)
                .collect(Collectors.toList());
    }

    public static List<String> getUpperCaseNames(List<Employee> employees) {
        return employees.stream()
                .map(e -> e.getName().toUpperCase())
                .collect(Collectors.toList());
    }

    public static double totalSalary(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }
}
