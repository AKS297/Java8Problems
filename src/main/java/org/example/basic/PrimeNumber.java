package org.example.basic;

import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumber {

    public void checkPrime(int n){
        if(n == 1){
            {
                System.out.println("Not a prime");
                return;
            }
        }

        for(int i = 2 ; i  <= Math.sqrt(n) ; i++){
            if(n % i == 0){
                System.out.println("Not a prime");
                return;
            }

        }
        System.out.println("Prime Number");
      /*  n > 1 && IntStream.rangeClosed(2,(int) Math.sqrt(n))
                .allMatch(a -> n % a == 0);
                */

        //using streams
        boolean isPrime = n > 1 && IntStream.rangeClosed(2,(int) Math.sqrt(n))
                .allMatch( i -> n % i == 0);
        System.out.println(isPrime ? "Prime" : "Not Prime");

        //for List of Numbers
        List<Integer> list = List.of(1,2,3,1,5,2,4,6,8,7);
     List<Integer> arrPrime =   list.stream().filter(number -> number > 1  //take Each Number
                     && IntStream.rangeClosed(2,(int)Math.sqrt(number)) //define loop from 2 to sqrt of number
                .allMatch(a -> number % a != 0))  // all match values
             .distinct()
             .collect(Collectors.toList());

     list.stream().filter(number -> number > 1 && IntStream.rangeClosed(2,(int)Math.sqrt(number))
             .allMatch(a-> number % a !=0))
                     .distinct()
                             .collect(Collectors.toList());

     System.out.println(arrPrime);

    }
}
