package com.java.practice;

import java.util.Scanner;

public class Loop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*int number;
        System.out.println("Enter a whole number");
        number = sc.nextInt();
        while(number > 0){
            System.out.println("Enter a whole number");
            number = sc.nextInt();
            System.out.println("You entered "+ number);
        }
        System.out.println("number after loop "+number);*/
/*
        for(int n = 1; n <= 3; n++ ){
            switch(n) {
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                default:
                    System.out.println("Default case");
                    break;
            }
        }
        System.out.println("After loop");*/

   /* for(int i = 1; i < 5; i++)
    {
        if(i == 3) break;
        System.out.println("Hello");
    }
        System.out.println("After the loop");*/

        for(int i = 1; i < 5; i++)
        {
            if(i == 3) System.exit(0);
            System.out.println("Hello");
        }
        System.out.println("After the loop");


    }

}
