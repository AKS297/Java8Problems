package org.example.strings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {
    public static void main(String[] args) {
        String s = "Hello";
        String result = "";
        char[] arr = s.toCharArray();
        for(int i =arr.length-1;i >=0 ;i--){
            result +=arr[i];
        }
        System.out.println(result);

      String reversed = IntStream.range(0,s.length())
              .mapToObj(a -> s.charAt(s.length()-a-1))
                .map(String::valueOf)
                .collect(Collectors.joining());

     String sorted = s.toLowerCase().chars().sorted()
                      .mapToObj(a -> String.valueOf((char)a))
                              .collect(Collectors.joining());
 System.out.println(sorted);
      System.out.println(reversed);
    }
}
