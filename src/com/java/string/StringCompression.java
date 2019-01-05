package com.java.string;

/* Problem Description:
    Compress a given string "aabbbccc" to "a2b3c3"
   constraint: in-place compression, no extra space to be used
   assumption : output size will not exceed input size..
   ex input:"abb" -> "a1b2" buffer overflow.. such inputs will not be given.*/

public class StringCompression {

    static String compressString(String s){
        StringBuilder sb = new StringBuilder();
        int count = 1,i = 0;
        for(; i< s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                count++;
            }else{
                sb.append(s.charAt(i)).append(count);
                count = 1;
            }
        }
        if(s.charAt(s.length() - 2) == s.charAt(s.length() - 1)){
            sb.append(s.charAt(i)).append(count);
        }else{
            sb.append(s.charAt(s.length()-1)).append(1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("abcde"));
    }
}
