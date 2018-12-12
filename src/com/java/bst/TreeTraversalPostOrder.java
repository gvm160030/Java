package com.java.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TreeTraversalPostOrder {
    static TreeNode root;

    TreeTraversalPostOrder() {
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

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TreeTraversalPostOrder tree = new TreeTraversalPostOrder();
        tree.root = new TreeNode(1);
        tree.root.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(3);
        System.out.println("Preorder traversal of binary tree is ");
        List<Integer> result = tree.postOrderTraversal(root);

        for (Integer e : result) {
            System.out.print(e);
        }
    }
}
