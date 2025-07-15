package org.example.arrays;

import java.util.Set;
import java.util.TreeSet;

public class Arrays {
    //Devisor of a number
    public int[] divisors(int n) {
        Set<Integer> set = new TreeSet<>();
        for(int i =1; i * i <= n ; i++){
            if(n % i == 0){
                set.add(i);
                set.add(n/i);
            }
        }
        int[] arr = new int[set.size()];
        int index = 0;
        for(Integer l : set){
            arr[index] = l;
            index++;
        }
        return arr;
    }

}
