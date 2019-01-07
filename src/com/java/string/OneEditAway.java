package com.java.string;
/*
Given two strings S and T, determine if they are both one edit distance apart.

ip : Pale  -> ple | removal
     pale -> pole | replacement
     pple -> apple | insertion
     dark -> duck | false since 2 letters are changed

op : true for all the scenarios because the resulting strings are either one insertion of the input string
 or replacement or deletion
 */
public class OneEditAway {

    static boolean isOneEditAway(String s1, String s2){
        // one edit check based on the lengths of the strings
        if (Math.abs(s1.length() - s2.length()) > 1) return false;

        String first = s1.length() < s2.length() ? s1 : s2;
        String second = s1.length() < s2.length() ? s2 : s1;

        int index1 = 0, index2 = 0;
        boolean foundDiff = false;

        while(index2 < second.length() && index1 < first.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){

                // Ensure that this is the first difference found
                if(foundDiff) return false;
                foundDiff = true;

                if(first.length() == second.length()){
                    index1++;
                }
            }else{
                index1++; // if matching move shorter pointer
            }
            index2++; // always move pointer for longer string
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isOneEditAway("ple","pl"));
    }
}
