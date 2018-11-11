package com.bst.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree, return the preorder traversal

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]

 */


public class TreeTraversalPreOrder {

    static TreeNode root;

    TreeTraversalPreOrder() {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null) return preOrder;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            preOrder.add(node.val);
            // right and then left, so that left pops first
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return preOrder;
    }

    /* RECURSIVE
public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> pre = new LinkedList<Integer>();
		preHelper(root,pre);
		return pre;
	}
	public void preHelper(TreeNode root, List<Integer> pre) {
		if(root==null) return;
		pre.add(root.val);
		preHelper(root.left,pre);
		preHelper(root.right,pre);
	}
*/


    public static void main(String[] args) {
        TreeTraversalPreOrder tree = new TreeTraversalPreOrder();
        tree.root = new TreeNode(1);
        tree.root.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(3);
        System.out.println("Preorder traversal of binary tree is ");
        List<Integer> result = tree.preorderTraversal(root);

        for (Integer e : result) {
            System.out.print(e);
        }
    }
}
