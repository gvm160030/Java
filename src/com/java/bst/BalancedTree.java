package com.java.bst;
/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as
a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

TC : O(N) ; SC : O(H)
 */
public class BalancedTree {
    static Node root;

    static class Node{
        int data;
        Node left,right;

        Node(int d){
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    static boolean isBalanced(Node root){

        return checkHeight(root) != Integer.MIN_VALUE;
    }

    private static int checkHeight(Node root) {
        if(root == null) return -1;
        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heigtDifference = Math.abs(leftHeight - rightHeight);
        if(heigtDifference > 1) {
            return Integer.MIN_VALUE;
        }else{
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        BalancedTree tree = new BalancedTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.right.left.right = new Node(5);
        System.out.println(isBalanced(root));
    }
}
