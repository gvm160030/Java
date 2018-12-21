package com.java.practice;

public class OOPS_TraingleProblem {

    static int mystery1(int a){
        System.out.println("m 1");
        return a/2;
    }

    static String mystery2(int b){
        String s = "m 2";
        System.out.println(s);
        for(int i =0; i < b;i++){
            s = s + " " +i;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println("main");
        System.out.println(mystery2(mystery1(4)));
        System.out.println("end");
    }
}
