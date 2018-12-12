package com.java.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversalInOrder {

    static TreeNode root;

    TreeTraversalInOrder() {
        root = null;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inOrderTraversal(TreeNode node) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        inorderIterativeLeft(node, result, stack);
        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            if (right != null) {
                result.add(right.val);
                right = right.right;
                if (right != null) {
                    stack.add(right);
                    inorderIterativeLeft(right, result, stack);
                }
            }
        }
        return result;
    }

    private void inorderIterativeLeft(TreeNode node, List<Integer> result, Stack<TreeNode> stack) {
        TreeNode left = node.left;
        while (left != null) {
            stack.push(left);
            left = left.left;
        }
    }


    /* RECURSIVE
        private void inorderRecursive(TreeNode node,List<Integer> res){
        if(node == null)return;
        inorderRecursive(node.left,res);
        res.add(node.val);
        inorderRecursive(node.right,res);
    }
     */


    public static void main(String[] args) {
        TreeTraversalInOrder tree = new TreeTraversalInOrder();
        tree.root = new TreeNode(1);
        tree.root.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(3);
        System.out.println("Preorder traversal of binary tree is ");
        List<Integer> result = tree.inOrderTraversal(root);

        for (Integer e : result) {
            System.out.print(e);
        }
    }
}
