package com.java.practice;

import java.util.Scanner;

public class OOPS_EvenOfEvens {


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int[] intArr = new int[10];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = kb.nextInt();
        }
        // Accumulate algorithm to find number of even elements
        int countEven = 0;
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] % 2 == 0) {
                countEven++;
            }
        }
        if (countEven % 2 == 0) { // even number of evens
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
