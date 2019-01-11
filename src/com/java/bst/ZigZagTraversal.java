package com.java.bst;

import java.util.*;

/*
Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class ZigZagTraversal {

    static TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ZigZagTraversal() {
        root = null;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> inrList = new ArrayList<>();
            while (size != 0) {
                TreeNode temp = q.poll();
                inrList.add(temp.val);
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
                size -= 1;
            }

            res.add(inrList);

        }

        for (int i = 1; i < res.size(); i += 2)
            Collections.reverse(res.get(i));

        return res;
    }

    public static void main(String[] args) {
        ZigZagTraversal tree = new ZigZagTraversal();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(9);
        tree.root.right = new TreeNode(20);
        tree.root.right.left = new TreeNode(15);
        tree.root.right.right = new TreeNode(7);
        List<List<Integer>> result = zigzagLevelOrder(root);
        for(List<Integer> l : result){
            System.out.println(Arrays.deepToString(l.toArray()));
        }
    }
}
