package com.java.practice;

/*
Given two number x and y find product using recursion.

Examples :

Input : x = 5, y = 2
Output : 10

Input : x = 100, y = 5
Output : 500
 */
public class ProductOfTwoNums {

    /*
    APPROACH
    1) If x is less than y, swap the two variables value
    2) Recursively find y times the sum of x
    3) If any of them become zero, return 0
     */

    // recursive function to calculate
    // multiplication of two numbers
    static int product(int x, int y)
    {
        // if x is less than
        // y swap the numbers
        if (x < y)
            return product(y, x);

            // iteratively calculate
            // y times sum of x
        else if (y != 0)
            return (x + product(x, y - 1));

            // if any of the two numbers is zero return zero
        else
            return 0;
    }

    // Driver Code
    public static void main (String[] args)
    {
        int x = 5, y = 2;
        System.out.println(product(x, y));
    }
}
