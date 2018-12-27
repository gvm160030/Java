package com.java.string;

import java.util.LinkedList;
import java.util.List;
/*
*
* Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */
public class LetterCombination {

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();

        if (digits.length() == 0)   return ans;

        String[] ref = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        ans.add("");

        while (ans.peek().length() != digits.length()) {
            String remove = ans.poll();
            String map = ref[digits.charAt(remove.length()) - '0'];
            for (int i = 0; i < map.length(); i++)
                ans.addLast(remove + map.charAt(i));
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
