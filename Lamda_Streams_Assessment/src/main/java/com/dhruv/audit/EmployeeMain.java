package com.dhruv.audit;

import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> employees = Employee.getSampleData();

        List<Employee> highEarners = EmployeeProcessor
                .filterEmployee(employees,
                        e-> e.getSalary() > 70000 &&
                                e.getDepartment().equals("ENGINEERING")
                );

        System.out.println("High Earning Engineers : ");
        highEarners.forEach(System.out::println);

        System.out.println("Uppercase Names : ");
        EmployeeProcessor.getUpperCaseNames(employees)
                .forEach(System.out::println);

        double total = EmployeeProcessor.totalSalary(employees);
        System.out.println("Total Salary Budget : " + total);
    }
}
