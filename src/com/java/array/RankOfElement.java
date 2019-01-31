package com.java.array;
/*

Given a stream of integers, lookup the rank of a given integer x. Rank of an integer in stream is “Total number of elements less than or equal to x (not including x)”.

If element is not found in stream or is smallest in stream, return -1.
Examples:

Input :  arr[] = {10, 20, 15, 3, 4, 4, 1}
              x = 4;
Output : Rank of 4 in stream is: 3
There are total three elements less than
or equal to x (and not including x)

Input : arr[] = {5, 1, 14, 4, 15, 9, 7, 20, 11},
           x = 20;
Output : Rank of 20 in stream is: 8

 */
public class RankOfElement {

    static class Node{
        Node left,right;
        int data,leftSize;
    }

    static Node newNode(int data){
        Node temp = new Node();
        temp.left = null;
        temp.right = null;
        temp.leftSize = 0;
        temp.data = data;
        return temp;
    }

    static Node insert(Node root, int data){
        if(root == null){
            return newNode(data);
        }
        if(data <= root.data){
            root.left = insert(root.left,data);
            root.leftSize++;
        }
        else
            root.right = insert(root.right,data);
        return root;
    }

    static int getRank(Node root, int x){
        if(root.data == x)
            return root.leftSize;

        if(x < root.data){
            if(root.left == null)
                return -1;
            else
                return getRank(root.left,x);
        }
        else{
            if(root.right == null) return -1;
            else {
                int rightSize = getRank(root.right,x);
                return root.leftSize + 1 + rightSize;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 1, 4, 4, 5, 9, 7, 13, 3 };
        int n = arr.length;
        int x = 4;

        Node root = null;
        for (int i = 0; i < n; i++)
            root = insert(root, arr[i]);

        System.out.println("Rank of " + x + " in stream is : "+getRank(root, x));

        x = 13;
        System.out.println("Rank of " + x + " in stream is : "+getRank(root, x));

    }
}
