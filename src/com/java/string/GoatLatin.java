package com.java.string;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
    public static String toGoatLatin(String S) {
        Set<Character> vowel = new HashSet<Character>();
        for (char c : "aeiouAEIOU".toCharArray()) vowel.add(c);
        String res = "";
        int i = 0, j = 0;
        for (String w : S.split("\\s")) {
            res += ' ' + (vowel.contains(w.charAt(0)) ? w : w.substring(1) + w.charAt(0)) + "ma";
            for (j = 0, ++i; j < i; ++j) res += "a";
        };
        return res.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(toGoatLatin("Java Programming is awesome"));
    }
}
