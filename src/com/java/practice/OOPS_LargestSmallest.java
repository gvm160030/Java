package com.java.practice;

import java.util.Arrays;
import java.util.Scanner;

public class OOPS_LargestSmallest {

    static void swapMaxMin(){
        Scanner kb = new Scanner(System.in);
        int[] array = new int[10];

        for(int i = 0; i< array.length; i++){
            array[i] = kb.nextInt();
        }
        int maxPosition = 0;
        int max = array[0];
        int minPosition = 0;
        int min = array[0];
        for(int i = 1;i<array.length;i++){
            if(array[i] > max){
                max = array[i];
                maxPosition = i;
            }
        }
        for(int j = 1;j<array.length;j++){
            if(array[j] < min){
                min = array[j];
                minPosition = j;
            }
        }
        array[minPosition] = max;
        array[maxPosition] = min;
        System.out.println(Arrays.toString(array));
    }
    public static void main(String[] args) {
        swapMaxMin();
    }
}
