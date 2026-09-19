package com.user.userinfo.learntest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SampleTest {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", 50000, "Engineering"),
                new Employee(2, "Alice", 60000, "Marketing"),
                new Employee(3, "Bob", 55000, "Sales"),
                new Employee(4, "John", 70000, "Engineering"),
                new Employee(5, "Alice", 80000, "Marketing"),
                new Employee(3, "Bob", 95000, "Sales")
        );

//        System.out.println("Original    List:");
//        employees.forEach(System.out::println);

        Map<String, List<Employee>> li = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getDepartment(),
                        Collectors.toList()
                ));

        System.out.println("Grouped by Department:");

        for (String key : li.keySet()) {
//            System.out.println("Department: " + key);
            List<Employee> empList = li.get(key);
                for (Employee emp : empList) {
//                    System.out.println(emp);
            }
            }

        employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);
    }

}
