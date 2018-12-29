package com.java.string;

/*
Given an input string, reverse the string word by word.

Example:

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces.
However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.

 */
public class ReverseStringWords {

    public static String reverseWords(String s) {
        String[] array = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i > 0; i--) {
            sb.append(array[i] + " ");
        }
        sb.append(array[0]);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("All is Well"));
    }
}
