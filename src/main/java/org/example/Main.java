package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Integer> list = List.of(1,2,3,1,5,2,4,6,8,7);
        //Filter odd and even number
        Map<Boolean, List<Integer>> collect = list.stream().collect(Collectors.partitioningBy(a -> a % 2 == 0));
         System.out.println(collect);

         //Frequency of number
        Map<Integer, Long> collect1 = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);

        //Frequency of String;
        String str = "hello";
        Map<Character, Long> collect2 = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
        Character c = collect2.entrySet().stream().filter(a -> a.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst().get();

        System.out.println(c);

        //Non Repeating Charcters to String
       LinkedHashMap<Character,Long> linkedHashMap = str.chars().mapToObj(a -> (char) a)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));

      String s= linkedHashMap.entrySet().stream().filter( a-> a.getValue() == 1L)
               .map(Map.Entry::getKey)
               .map(String::valueOf)
               .collect(Collectors.joining());

      System.out.println(s);
    }
}