package org.example.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaString {
    public static void main(String[] args) {
        String s = "Hello";
        s.chars().sorted().mapToObj(a -> (char) a)
                .map(String::valueOf)
                .collect(Collectors.joining());

        IntStream.rangeClosed(0,s.length())
                .mapToObj(a -> s.charAt(s.length()-a-a))
                .map(String::valueOf)
                .collect(Collectors.joining());

        s.chars().mapToObj(a -> (char)a)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(r-> r.getValue() == 1l)
                .map(Map.Entry::getKey)
                .map(String::valueOf)
                .collect(Collectors.joining());

        s.chars().sorted()
                .mapToObj(a -> (char)a)
                .map(String::valueOf)
                .collect(Collectors.joining());

        IntStream.range(0,s.length())
                .mapToObj(sa -> s.charAt(s.length()-sa-1))
                .map(String::valueOf)
                .collect(Collectors.joining());

        s.chars()
                .mapToObj(a -> (char)a)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(a -> a.getValue() == 1L)
                .map(Map.Entry::getKey)
                .map(String::valueOf)
                .collect(Collectors.joining());

    }
}
