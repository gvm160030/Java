package com.java.practice;

import java.util.Scanner;

public class OOPS_Positive {
    static boolean isPositive(int number){
        if(number > 0){
            return true;
        }
        return false;
    }

    static int countPositive(){
        int count = 0;
        for(int i = 0; i < 5; i++){
            Scanner kb = new Scanner(System.in);
            int number = kb.nextInt();
            if(isPositive(number)){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPositive());
    }
}
