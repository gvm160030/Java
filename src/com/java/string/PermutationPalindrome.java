package com.java.string;

/*Given a string, write a function to check if it is a
        * permutation of a palindrome. A palindrome is a word
        * or phrase that is same forwards and backwards. A
        * permutation is a rearrangement of letters. The palindrome
        * does not need to be limited to just dictionary words.
        *
        * ex. Input : Tact Coa
        * Output : True (permutations : "taco cat", "atco cta", etc.)
*/

public class PermutationPalindrome {
    static boolean isPermutationPalindrome(String s){
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for(char c : s.toCharArray()){
            int x = getCharNumber(c);
            if(x != -1){
                table[x]++;
                if(table[x] % 2 == 1){
                    countOdd++;
                }else{
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    private static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if(val >= a && val <= z){
            return val - a;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(isPermutationPalindrome("Taco catok"));
    }
}
