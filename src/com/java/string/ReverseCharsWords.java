package com.java.string;

public class ReverseCharsWords {

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int i=0;
        for(; i < words.length-1; i++)
            sb.append(reverse(words[i])+" ");

        sb.append(reverse(words[i]));
        return sb.toString();
    }

    private static String reverse(String word){
        StringBuilder sb = new StringBuilder();
        for(int i=word.length()-1; i >= 0; i--)
            sb.append(word.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's see what happens"));
    }
}
