package com.java.string;
/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
 */
public class UniqueCharInString {
    public static int firstUniqChar(String s) {
        int loc = s.length();
        for (char c='a'; c<='z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && s.indexOf(c) == s.lastIndexOf(c)) {
                loc = Math.min(index, loc);
            }
        }
        return loc == s.length() ? -1 : loc;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("roar"));
    }
}
