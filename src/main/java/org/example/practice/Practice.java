package org.example.practice;

public class Practice {
    public static void main(String[] args) {
        int [] arr = {5,2,1,8,9,0};

        //Sort
        for(int i = 0;i < arr.length;i++){
            for(int j = 0; j < arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int n : arr)
            System.out.print(n + " ");

        System.out.println("============Reverse Array===============");

        int right = arr.length-1;
        int left = 0;

        while(left < right){
           int temp = arr[left];
           arr[left] = arr[right];
           arr[right] = temp;
           left++;
           right--;
        }
        for(int n : arr)
            System.out.print(n + " ");
        System.out.println("====================");

        System.out.println("================= Print All SubArrays ======================");

        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length;j++){
                for(int k = i; k <= j; k++){
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }

        }

        System.out.println(" ========== Maximum sum of SubArray ==============");
        int maxSum = arr[0];
        for(int i = 0; i < arr.length; i++){
            int currentSum = 0;
            for(int j =i ; j < arr.length; j++){
                currentSum = currentSum + arr[j];
                maxSum = Math.max(maxSum,currentSum);
            }
        }
        System.out.println("Maximum sum SubArray is " + maxSum);

        System.out.println("Max Sub Array Using Kadane's Algo ");

        int c_sum = arr[0];
        int m_sum = arr[0];
        for(int i = 1; i < arr.length;i++){
         c_sum = Math.max(c_sum,c_sum+arr[i]);
         m_sum = Math.max(m_sum,c_sum);
        }
        System.out.println(m_sum);
    }

}
