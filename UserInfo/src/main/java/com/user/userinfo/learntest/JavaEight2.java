package com.user.userinfo.learntest;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JavaEight2 {

    public static void main(String[] args) {

//        https://medium.com/@asishpanda444/stream-api-coding-qna-8df8682b7e2a

        List<Integer> list = new ArrayList<>(List.of(3, 2, 1, 10, 11, 12, 13, 14, 15, 1, 2, 3));
        List<String> list2 = new ArrayList<>(
                List.of("Amit", "booba", "chut", "Ayush", "stream API", "APIlodu", "chut" , "Ayush"));
        List<String> words = Arrays.asList("Stream", "API", "is", "powerful");
        List<String> wordsNull = Arrays.asList("Stream", "API", null, "is", null, "powerful");

        List<List<Integer>> list3 = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6));
        String str = "abcdefabc";
        String str2 = " sumit";

        // 1. Even Number
        list.stream().filter(e -> e % 2 == 0).forEach(System.out::println);

        System.out.println("second question");

        // 2. Max
        Integer maxi = list.stream().max((x, y) -> x.compareTo(y)).get();
        System.out.println(maxi);

        System.out.println("3rd question");

        // 3. Sort a List
        list.stream().sorted().forEach(e -> System.out.print(e + " "));

        System.out.println("4th question");

        // 4. Count Strings with Specific Prefix
        String ans = list2.stream().filter(e -> e.startsWith("A")).findFirst().orElse(null);
        System.out.println(ans);

        list2.stream().filter(e -> e.startsWith("A")).forEach(System.out::println);

        System.out.println("5th question");

        // 5. Find First Non-Repeated Character in a String

        // Map<Character, Long> map5 = str.chars().mapToObj(ch -> (char) ch)
        // .collect(Collectors.groupingBy(e -> e, LinkedHashMap::new,
        // Collectors.counting()));

        // Character ans5 = map5.entrySet().stream().filter(e -> e.getValue() == 1)
        // .map(Map.Entry::getKey).findFirst().orElse(null);
        // System.out.println(ans5);

        Character ans5 = str.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().orElse(null);
        Character ans55 = str.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1)
                .skip(1)
                .map(Map.Entry::getKey).findFirst().orElse(null);

        System.out.println("First non repeating is " + ans5);
        System.out.println("Second non repeating is " + ans55);

        System.out.println("6th question");

        // 6. Convert List of Strings to Uppercase
        list2.stream().map(e -> e.toUpperCase()).toList().forEach(System.out::println);

        System.out.println("7th Question");

        // 7. Sum of Numbers in a List
        Optional<Integer> sumOptional = list.stream().reduce((x, y) -> x + y);
        System.out.println(sumOptional);

        System.out.println("8th question");

        // 8 Any match
        Optional<String> ans8 = list2.stream().filter(e -> e.contains("API")).findFirst(); // it will first
        // matching;
        list2.stream().filter(e -> e.contains("API")).forEach(System.out::println);
        boolean ans88 = list2.stream().anyMatch(e -> e.contains("API"));
        System.out.println(ans8 + " " + ans88);

        System.out.println("9th question");

        // 9. Find Duplicate Elements in a List
        Set<Integer> unique = new HashSet<>();
        Set<Integer> duplicate = list.stream().filter(e -> !unique.add(e)).collect(Collectors.toSet());
        System.out.println(duplicate);

        System.out.println("Using group by");

        list.stream().collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey).forEach(System.out::println);

        System.out.println("using collectors");
        list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("10th Question");

        // 10. Group Strings by Length
        str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.print(entry.getKey());
                    System.out.println(entry.getValue());
                });

        System.out.println("11th question");
        // 11. Flatten a List of Lists

        list3.stream().flatMap(List::stream).forEach(System.out::println);

        System.out.println("12th Question");

        // 12. Concatenate Strings
        String ans12 = words.stream().reduce("", (s1, s2) -> s1 + " " + s2).trim();
        System.out.println(ans12);

        System.out.println("13th question");
        // 13. Find the Longest String

        String ans13 = words.stream()
                .reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2)
                .orElse(null);

        System.out.println(ans13);

        System.out.println("14th Question");

        // 14. Count Frequency of Characters in a String

        Map<Character, Long> ans14 = str.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()));

        System.out.println(ans14);

        System.out.println("17th question");

        // 17. Remove Null Values
        wordsNull.stream().filter(e -> e != null).collect(Collectors.toList()).forEach(System.out::println);

        // 18. Calculate Average of Numbers
        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new RuntimeException("Not found"));
        System.out.println(avg);


//                 19. Collect Map from List

        System.out.println("19th Question");

        Map<String, Integer> ans19= words.stream()
                .collect(Collectors.toMap(e-> e, String::length));
        System.out.println(ans19);


    }

}
