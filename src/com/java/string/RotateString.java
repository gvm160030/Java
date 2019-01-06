package com.java.string;
/*
Given two strings s1,s2 write code to check if s2 is rotation of s1
 */
public class RotateString {

    static boolean rotateString(String s1, String s2){
        int len = s1.length();
        String combined ="";
        if(len == s2.length() && len > 0){
            combined = s1.concat(s1);
            }
        return isSubstring(combined,s2);
    }

    private static boolean isSubstring(String combined, String s2) {
        return combined.contains(s2);
    }

    public static void main(String[] args) {
        System.out.println(rotateString("waterbottlee","erbottleewat"));
    }
}
