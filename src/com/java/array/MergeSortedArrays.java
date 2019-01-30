package com.java.array;

import java.util.Arrays;

/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B.
The number of elements initialized in A and B are m and n respectively.

 */
public class MergeSortedArrays {

    /*

    The key to solve this problem is moving element of A and B backwards.
    If B has some elements left after A is done, also need to handle that case.

     */
    static int[] merge(int[] A, int[] B){
        int m = A.length; int n = B.length;
        A = Arrays.copyOf(A, m+n);
        while(m > 0 && n > 0){
            if(A[m-1] > B[n-1]){
                A[m+n-1] = A[m-1];
                m--;
            }else{
                A[m+n-1] = B[n-1];
                n--;
            }
        }

        while(n > 0){
            A[m+n-1] = B[n-1];
            n--;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {1,3,5,7};
        int[] B = {5,7,9};
        int[] result = merge(A,B);
        for(int i = 0; i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
