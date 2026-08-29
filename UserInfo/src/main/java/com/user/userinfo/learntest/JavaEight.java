package com.user.userinfo.learntest;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaEight {

    public static void main(String[] args) {

        String str = "SumitSumitKumar";
        String str1 = "abcba";

        Character ans1 = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().findFirst().get().getKey();

        System.out.println("First repeating character is: " + ans1);

        Character ans2 = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                        .filter(e -> e.getKey() != null && e.getValue() > 1)
                                .map(Map.Entry::getKey)
                                        .skip(1).findFirst().orElse(null);

        System.out.println("Second repeating character is: " + ans2);

        Character ans3= str.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().
                filter(e-> e.getKey()!=null && e.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);

        System.out.println("First non-repeating character is: " + ans3);

        Character ans4= str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(e-> e, LinkedHashMap::new , Collectors.counting()))
                .entrySet().stream()
                .filter(e-> e.getValue()==1)
                .skip(1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow( () -> new IllegalStateException("Not found"));

        System.out.println("Second non-repeating character is: " + ans4);

        LinkedHashMap<Character, Long> map = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(e-> e, LinkedHashMap::new , Collectors.counting()));

        for(Character ch : map.keySet()){
            System.out.println(ch + " : " + map.get(ch));
        }


        System.out.println("===========================================================================");
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", 50000),
                new Employee(2, "Rahul", 80000),
                new Employee(3, "Priya", 70000),
                new Employee(4, "Neha", 90000),
                new Employee(5, "Raj", 60000)
        );

        // Find the employee with the highest salary
        Employee highestSalaryEmployee = employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .orElse(null);

        System.out.println("Employee with the highest salary: " + highestSalaryEmployee);

        Employee e1 = employees.stream()
                .sorted((e2, e3) -> Double.compare(e2.getSalary(), e3.getSalary()))
                .skip(2).findFirst().orElse(null);
        System.out.println("Employee with the third highest salary: " + e1);
    }

}
