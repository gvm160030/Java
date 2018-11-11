package com.bst.java;

import java.util.Stack;

/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

 */
public class ConstructBTUsingPreIn {
    TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    ConstructBTUsingPreIn() {
        root = null;
    }

    public static TreeNode buildTree(int[] pre, int[] in) {
        if (pre.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int index = 0;
        for (int i = 1; i < pre.length; i++) {
            TreeNode cur = stack.peek();
            if (cur.val != in[index]) {
                cur.left = new TreeNode(pre[i]);
                stack.push(cur.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == in[index]) {
                    cur = stack.pop();
                    index++;
                }
                cur.right = new TreeNode(pre[i]);
                stack.push(cur.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        TreeNode result = buildTree(preOrder, inorder);
        System.out.println("The Tree is with root : " + result.val + " left node : " + result.left.val + " right node : " + result.right.val);

    }
}
