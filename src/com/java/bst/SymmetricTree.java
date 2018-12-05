package com.java.bst;

import java.util.Stack;

/*
* Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

* */
public class SymmetricTree {
    static TreeNode root;

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            this.val = x;
        }
    }

    SymmetricTree(){
        root = null;
    }
/*public boolean isSymmetric(TreeNode root) {
    return root==null || isSymmetricHelp(root.left, root.right);
}

private boolean isSymmetricHelp(TreeNode left, TreeNode right){
    if(left==null || right==null)
        return left==right;
    if(left.val!=right.val)
        return false;
    return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
}*/

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);

        TreeNode left, right;

        while (!stack.empty()) {

            right = stack.pop();
            left = stack.pop();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();
        /*tree.root = new TreeNode(1);
        tree.root.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(3);*/
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(3);
        boolean result = tree.isSymmetric(root);
        System.out.println("Is the binary tree symmetric : "+result);
    }
}
