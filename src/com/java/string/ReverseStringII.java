package com.java.string;

/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters
counting from the start of the string.
If there are less than k characters left, reverse all of them.
If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left
the other as original.

Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"

Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
 */
public class ReverseStringII {
    public static String reverseStringK(String s,int k){
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            int end = i + k - 1;
            if (end > s.length()-1) end = s.length() - 1;
            while (start < end) {
                char temp = chars[end];
                chars[end] = chars[start];
                chars[start] = temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        System.out.println(reverseStringK("abcdefg",3));
    }
}
