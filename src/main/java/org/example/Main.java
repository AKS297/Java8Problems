package org.example;

import org.example.arrays.Arrays;
import org.example.basic.PrimeNumber;
import org.example.comparator.Student;
import org.example.sorting.SortStreams;

import java.util.*;
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

      str.chars().mapToObj(d -> (char) d)
                      .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                              .entrySet()
                                      .stream()
                                              .filter(a -> a.getValue() ==1L)
                                                      .map(Map.Entry::getKey)
                                                              .map(String::valueOf)
                                                                      .collect(Collectors.joining());

      str.chars().mapToObj(a -> (char) a)
                      .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                              .entrySet().stream().filter(b -> b.getValue() == 1L)
                      .map(Map.Entry::getKey)
                              .map(String::valueOf)
                                      .collect(Collectors.joining());

      System.out.println(s);
        System.out.println("====================Sorting======================");
        List<Integer> list1 = List.of(1,3,8,1,3,5,0,9,6);

        SortStreams sortStreams = new SortStreams();
        sortStreams.sorting(list1);

        Arrays arrays = new Arrays();
        arrays.divisors(6);

        PrimeNumber primeNumber = new PrimeNumber();
        primeNumber.checkPrime(3);

        //for List of Numbers

        List<Student> students = new ArrayList<>();
        Student student = new Student("Akshay",25);
        Student student1 = new Student("Akshay",26);
        Student student2 = new Student ("Bob",24);

        students.add(student);
        students.add(student1);
        students.add(student2);

        students.stream().sorted(Comparator.comparing(Student::getName).reversed()
                .thenComparing(Student::getAge).reversed())
                .forEach(a->System.out.println(a.getAge()));

    }

}