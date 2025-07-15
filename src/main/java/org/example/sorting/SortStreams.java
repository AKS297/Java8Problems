package org.example.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortStreams {

   /* List<Integer> list = List.of(1,3,8,1,3,5,0,9,6);
   */
    //sort in reverse
    public void sorting(List<Integer> list1){
      List<Integer> sortedList = list1.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    System.out.println(sortedList);

    //using comparator

     List<Integer> sortedList1 =   list1.stream().sorted((a,b) -> b-a).collect(Collectors.toList());
     System.out.println(sortedList1);

     //max value
       Integer max = list1.stream().sorted(Comparator.reverseOrder()).findFirst().get();
       System.out.println(max + " is maximum number");

       //second largest in list
       Integer secondmax = list1.stream().sorted(Collections.reverseOrder()).limit(2).skip(1).findFirst().get();
       System.out.println(secondmax + " Is the second largest in the list");
    }
}
