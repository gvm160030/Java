package com.java.string;

// Java program to check whether two strings are
// Permutations of each other

import java.util.Arrays;

public class CheckPermutation {
    static boolean arePermutation(String str1, String str2)
    {
        // Get lengths of both strings
        int n1 = str1.length();
        int n2 = str2.length();

        // If length of both strings is not same,
        // then they cannot be Permutation
        if (n1 != n2)
            return false;
        if(!sort(str1).equals(sort(str2)))
                return false;

        return true;
    }

    static String sort(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    /* Driver program to test to print printDups*/
    public static void main(String[] args)
    {
        String str1 = "god";
        String str2 = "dog";
        if (arePermutation(str1, str2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
