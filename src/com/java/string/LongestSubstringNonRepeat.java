package com.java.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNonRepeat {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        Set<Character> chars = new HashSet<>();
        int max = 1, head = 0, tail = 0;

        while (head < s.length()) {
            char currChar = s.charAt(head);

            if (!chars.contains(currChar)) {
                chars.add(currChar);
                max = Math.max(max, chars.size());
                head++;
            } else {
                chars.remove(s.charAt(tail));
                tail++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbb"));
    }
}
