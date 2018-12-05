package com.java.bst;

import java.util.LinkedList;

public class MaxDepthOfTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            this.val = x;
        }
    }
    static TreeNode root;
    MaxDepthOfTree(){
        root = null;
    }

    public int maxDepthRecursive(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDepthRecursive(root.left);
        int right = maxDepthRecursive(root.right);
        return Math.max(left, right) + 1;
    }

    public int maxDepthIterative(TreeNode root) {
        if(root == null){
            return 0;
        }

        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> counts = new LinkedList<Integer>();

        nodes.add(root);
        counts.add(1);

        while(!nodes.isEmpty()){
            TreeNode curr = nodes.remove();
            int count = counts.remove();

            if(curr.left == null && curr.right == null){
                return count;
            }

            if(curr.left != null){
                nodes.add(curr.left);
                counts.add(count+1);
            }

            if(curr.right != null){
                nodes.add(curr.right);
                counts.add(count+1);
            }
        }

        return 0;
    }


    public static void main(String[] args){
        MaxDepthOfTree tree = new MaxDepthOfTree();
        tree.root = new TreeNode(1);
        tree.root.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(3);
        int result = tree.maxDepthRecursive(root);
        System.out.println("Max Depth of binary tree is : "+result);
    }
}
