package com.java.bst;
/*
A program to check if a binary tree is BST or not
A binary search tree (BST) is a node based binary tree data structure which has the following properties.
• The left subtree of a node contains only nodes with keys less than the node’s key.
• The right subtree of a node contains only nodes with keys greater than the node’s key.
• Both the left and right subtrees must also be binary search trees.

APPROACH : For each node, check if max value in left subtree is smaller than the node
and min value in right subtree greater than the node

 */
public class ValidateBST {

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

    static boolean checkBST(Node n){
        return checkBST(root,null,null);
    }

    static boolean checkBST(Node n, Integer min, Integer max){
        if(n == null) return true;
        if((min != null && n.data <= min) || (max != null && n.data > max)){
            return false;
        }
        if(!checkBST(n.left,min,n.data) || !checkBST(n.right, n.data, max)){
            return false;
        }
      return true;
    }

    public static void main(String[] args) {
        ValidateBST tree = new ValidateBST();
        tree.root = new Node(8);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        System.out.println(checkBST(root));
    }

}
