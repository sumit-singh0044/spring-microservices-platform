package com.user.userinfo.learntest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface AddTest {
    int addNumbers(int a, int b);
}

public class NewTest {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        AddTest add= (a, b) -> a + b;

        AddTest add2 = new AddTest() {
            @Override
            public int addNumbers(int a, int b) {
                return a + b;
            }
        };

        System.out.println(add.addNumbers(5, 3));
        System.out.println(add2.addNumbers(5, 3));

        List<List<Integer>> list = new ArrayList<>(List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        ));
        list.stream()
                .flatMap(e -> e.stream())
                .forEach(System.out::print);

        List<Integer> list2 = new ArrayList<>(List.of(1,2,3,4,5,6,7,8));

        list2.stream()
                .collect(Collectors.partitioningBy(e-> e%2==0))
                .entrySet().stream()
                .forEach(System.out::print);
    }

}
