package com.java.practice;

import java.util.Scanner;

public class OOPS_Array {
    static int[] store(){
        Scanner kb = new Scanner(System.in);
        int[] array = new int[10];
        for(int i = 0;i<array.length;i++)
        array[i] = kb.nextInt();
        return array;
    }

    public static void main(String[] args) {
        System.out.println(store().length);
    }
}
