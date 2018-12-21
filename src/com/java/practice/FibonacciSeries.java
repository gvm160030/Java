package com.java.practice;

public class FibonacciSeries {

    //O(n-1)+O(n-2)
    private static int fibRecursive(int n){
        if(n<=1){
            return n;
        }
        return fibRecursive(n-1)+fibRecursive(n-2);
    }

    // Time Complexity : O(n) | Space Complexity : O(n)
    private static int fibDP(int n){
        int fib[] = new int[n+2];
        int i;
        fib[0] = 0;
        fib[1] = 1;

        for(i = 2;i<=n;i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    // Time Complexity : O(n) | Space Complexity : O(1)
    private static int fibIterative(int n){
        int a = 0, b = 1, c;
        if(n == 0) return a;
        for(int i = 2; i<= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(fibIterative(9));
    }
}
