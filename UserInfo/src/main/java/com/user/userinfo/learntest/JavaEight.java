package com.user.userinfo.learntest;

import java.util.LinkedHashMap;
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
    }

}
