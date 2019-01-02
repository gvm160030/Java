package com.java.string;

public class ReverseString {

    public static String reverseIterative(String s){
        char[] chars = s.toCharArray();

        int low = 0;
        int high = chars.length - 1;

        while (low < high)
        {
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;

            low++;
            high--;
        }

        return new String(chars);

        /*
        StringBuilder sb = new StringBuilder();

        for(int i = s.length(); i > 0; i--) {
            sb.append(s.charAt(i-1));
        }

        return sb.toString();
         */
    }

    public static String reverseRecursive(String s){
        if ((null == s) || (s.length()  <= 1)) {
            return s;
        }
        return reverseRecursive(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverseIterative("GAURI"));
    }
}
