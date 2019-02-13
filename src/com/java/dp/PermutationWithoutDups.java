package com.java.dp;

import java.util.ArrayList;

/*

Permutation of String which is unique

 */
public class PermutationWithoutDups {

    static ArrayList<String> getPerms(String s){
        ArrayList<String> result = new ArrayList<>();
        getPerms("",s,result);
        for(String str : result){
            System.out.println(str);
        }
        return result;
    }

    static void getPerms(String prefix, String remainder, ArrayList<String> result){

        if(remainder.length() == 0) result.add(prefix);

        int len = remainder.length();
        for(int i = 0; i<len; i++){
            String before = remainder.substring(0,i);
            String after = remainder.substring(i+1, len);
            char c = remainder.charAt(i);
            getPerms(prefix + c,before + after, result);
        }
    }

    public static void main(String[] args) {
        getPerms("abc");
    }
}
