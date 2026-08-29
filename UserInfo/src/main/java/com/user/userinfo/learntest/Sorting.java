package com.user.userinfo.learntest;

import java.util.Arrays;
import java.util.List;

public class Sorting {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", 50000),
                new Employee(2, "Alice", 60000),
                new Employee(3, "Bob", 55000)
        );

        System.out.println("Before sorting:");
        employees.forEach(System.out::println);

        // Sort employees by salary in ascending order
        employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

        System.out.println("\nAfter sorting by salary (ascending):");
        employees.forEach(System.out::println);
    }

}
