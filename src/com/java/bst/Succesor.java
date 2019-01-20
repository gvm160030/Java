package com.java.bst;
/*
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
Time is O(log(n)) and space is O(1)
 */
public class Succesor {

    static TreeNode root;

    static class TreeNode{
        int val;
        TreeNode left,right;

        TreeNode(int d){
            this.val = d;
            this.left = null;
            this.right = null;
        }
    }
    static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null)
            return null;

        TreeNode next = null;
        TreeNode c = root;
        while(c!=null && c.val!=p.val){
            if(c.val > p.val){
                next = c;
                c = c.left;
            }else{
                c= c.right;
            }
        }

        if(c==null)
            return null;

        if(c.right==null)
            return next;

        c = c.right;
        while(c.left!=null)
            c = c.left;

        return c;
    }

    public static void main(String[] args) {
        Succesor tree = new Succesor();
        tree.root = new TreeNode(8);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(10);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(6);
        System.out.println(inorderSuccessor(root,new TreeNode(1)).val);
    }
}
