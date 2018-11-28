package com.java.string;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String key = String.valueOf(a);
            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] str = {"eat","ate","tea","tan","nat","bat"};
        List<List<String>> list = groupAnagrams(str);
        for(List<String> element : list){
            for(String e : element){
                System.out.print(e+' ');
            }
            System.out.println();
        }
    }
}
