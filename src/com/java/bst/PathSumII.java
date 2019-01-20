package com.java.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class PathSumII {
    static TreeNode root;

    static class Node {
        TreeNode treeNode;
        List<Integer> list;
        int sum;

        Node(TreeNode treeNode, List<Integer> list, int sum) {
            this.treeNode = treeNode;
            this.list = list;
            this.sum = sum;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int d) {
            this.val = d;
        }
    }

    static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(new Node(root, list, sum));

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            TreeNode treeNode = node.treeNode;
            List<Integer> sol = node.list;
            sol.add(treeNode.val);
            if (treeNode.left == null && treeNode.right == null && treeNode.val == node.sum) {

                result.add(new ArrayList<Integer>(sol));
            } else {
                if (treeNode.right != null) {
                    stack.push(new Node(treeNode.right, new ArrayList<Integer>(sol), node.sum - treeNode.val));
                }
                if (treeNode.left != null) {
                    stack.push(new Node(treeNode.left, new ArrayList<Integer>(sol), node.sum - treeNode.val));
                }
            }

        }
        return result;


    }

    public static void main(String[] args) {
        PathSumII tree = new PathSumII();
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(4);
        tree.root.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(11);
        tree.root.right.left = new TreeNode(13);
        tree.root.right.right = new TreeNode(4);
        tree.root.left.left.left = new TreeNode(7);
        tree.root.left.left.right = new TreeNode(2);
        tree.root.right.right.left = new TreeNode(5);
        tree.root.right.right.right = new TreeNode(1);
        List<List<Integer>> result = pathSum(root, 22);
        System.out.println(result.size());
        for (List<Integer> list : result) {
            for (Integer e : list) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
