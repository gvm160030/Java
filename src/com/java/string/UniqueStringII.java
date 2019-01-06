package com.java.string;

import java.util.Arrays;

// Java program to check string with unique
// characters using sorting technique
// TS : O(N log N) | O(1)
public class UniqueStringII {
    static boolean uniqueCharacters(String str) {
        char[] chArray = str.toCharArray();

        // Using sorting
        // Arrays.sort() uses binarySort in the background
        // for non-primitives which is of O(nlogn) time complexity
        Arrays.sort(chArray);

        for (int i = 0; i < chArray.length - 1; i++) {
            // if the adjacent elements are not
            // equal, move to next element
            if (chArray[i] != chArray[i + 1])
                continue;

                // if at any time, 2 adjacent elements
                // become equal, return false
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(uniqueCharacters("Roar"));
    }
}
