package com.java.dp;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {

    static List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        dfs(result, "", n, n);
        for(String str : result){
            System.out.println(str);
        }
        return result;
    }
    /*
    left and right represents the remaining number of ( and ) that need to be added.
    When left > right, there are more ")" placed than "(". Such cases are wrong and the method stops.
    */
    static void dfs(ArrayList<String> result, String s, int left, int right){
        if(left > right)
            return;

        if(left==0&&right==0){
            result.add(s);
            return;
        }

        if(left>0){
            dfs(result, s+"(", left-1, right);
        }

        if(right>0){
            dfs(result, s+")", left, right-1);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
