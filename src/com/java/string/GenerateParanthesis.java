package com.java.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class GenerateParanthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left : generateParenthesis(c))
                    for (String right : generateParenthesis(n - 1 - c))
                        ans.add("(" + left + ")" + right);
         Collections.sort(ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        for(String e : result){
            System.out.println(e);
        }
    }
}
