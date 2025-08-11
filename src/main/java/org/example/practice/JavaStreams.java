package org.example.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) {
        int [] arr = {1,2,1,3,5,3,5};
        //frequesncy of Each Element
    Map<Integer, Long> frequency = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    System.out.println(frequency);

    //Second Highest Number
        Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .limit(2)
                .skip(1)
                .findFirst()
                .ifPresent(a -> System.out.println(a));

        //Separate odd and even numbers
        Map<Boolean, List<Integer>> collect = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.partitioningBy(a -> a % 2 == 0));
        System.out.println(collect);

        //Prime Numbers
        Arrays.stream(arr)
                .boxed()
                .filter(number -> number > 2 && IntStream.rangeClosed(2,(int) Math.sqrt(number))
                .allMatch( a-> number % a !=0))
                .collect(Collectors.toList());





    }
}
