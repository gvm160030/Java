package com.java.bst;

/*
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
 */
public class SquareRoot {

    public static int mySqrt(int x) {
        if(x < 1) return 0;
        int low = 1;
        int high = x;
        while(low <= high){
            int mid = (high - low) / 2 + low;
            if(x / mid == mid) return mid;
            if(x / mid > mid) low = mid + 1;
            if(x / mid < mid) high = mid - 1;
        }
        return high;
    }

    public static void main(String[] args) {
        System.out.println("The square root is : "+mySqrt(8));
    }

}
