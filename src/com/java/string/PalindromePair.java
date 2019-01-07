package com.java.string;

import java.util.ArrayList;
import java.util.List;

public class PalindromePair {
    public static List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> finalIndex =new ArrayList<List<Integer>>();

        auxPalindromePairs(words,new ArrayList<Integer>(),finalIndex,0);
        return finalIndex;
    }
    static void auxPalindromePairs(String words[], List<Integer> index, List<List<Integer>> finalIndex, int start)
    {
        if(index.size()==2)
        {
            if(isPalidrome(words[index.get(0)]+words[index.get(1)]))
            {
                finalIndex.add(new ArrayList(index));
            }
            if(isPalidrome(words[index.get(1)]+words[index.get(0)]))
            {
                List<Integer> temp=new ArrayList<Integer>();
                temp.add(index.get(1));
                temp.add(index.get(0));
                finalIndex.add(temp);
            }
        }
        else
        {
            for(int i=start;i<words.length;i++)
            {
                if(index.contains(i)) continue;
                index.add(i);
                auxPalindromePairs(words,index,finalIndex, i+1);
                index.remove(index.size()-1);
            }
        }
    }
    static boolean isPalidrome(String s)
    {
        int low=0, high=s.length()-1;
        while(low<high)
        {
            if(s.charAt(low++)!=s.charAt(high--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] array = {"abcd","dcba","lls","s","sssll"};
        System.out.println(palindromePairs(array));
    }
}
