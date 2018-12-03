package com.java.bst;

import java.util.Stack;

public class PathSum {
    /*
    Given a binary tree and a sum, determine if the tree has a
    root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1


     */
    static TreeNode root;

    PathSum() {
        root = null;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    /*

    public boolean hasPathSum2(TreeNode root, int sum) {
		if (root == null) return false;
		if (root.left == null && root.right == null && sum == root.val)
				return true;
		return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
}

    */

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null && node.val == sum) {
                return true;
            }
            if (node.left != null) {
                node.left.val = node.val + node.left.val;
                stack.push(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val + node.right.val;
                stack.push(node.right);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        PathSum tree = new PathSum();
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(4);
        tree.root.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(11);
        tree.root.right.left = new TreeNode(13);
        tree.root.right.right = new TreeNode(4);
        tree.root.left.left.left = new TreeNode(7);
        tree.root.left.left.right = new TreeNode(2);
        tree.root.right.right.right = new TreeNode(1);
        int sum = 21;
        boolean result = tree.hasPathSum(root, sum);
        System.out.println("Has the path sum "+ sum +"? : " + result);
    }
}
