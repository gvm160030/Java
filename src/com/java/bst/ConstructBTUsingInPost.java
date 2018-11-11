package com.bst.java;
/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */

/*
APPROACH

Idea is basically pop off the last value in post order array,
find the value in the inorder array (mid).
Create the root node and find its right and left subtrees by recursively calling the function,
this time for the right and left subtree.
Right subtree range is mid + 1 to cur inorder end index
while left subtree range is cur inorder start to mid - 1. return root.

 */
public class ConstructBTUsingInPost {
    TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    ConstructBTUsingInPost() {
        root = null;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] postEnd = new int[1];
        postEnd[0] = postorder.length - 1;
        return buildTree(postEnd, 0, inorder.length - 1, inorder, postorder);

    }

    public static TreeNode buildTree(int[] postEnd, int startIn, int endIn, int[] inorder, int[] postorder) {

        if (postEnd[0] < 0 || startIn > endIn) {
            return null;
        }

        //pop off end of postOrder
        int val = postorder[postEnd[0]];

        int mid = 0;
        for (int i = startIn; i <= endIn; i++) {
            if (inorder[i] == val) {
                mid = i;
                break;
            }
        }

        TreeNode root = new TreeNode(val);
        postEnd[0] = postEnd[0] - 1;
        root.right = buildTree(postEnd, mid + 1, endIn, inorder, postorder);
        root.left = buildTree(postEnd, startIn, mid - 1, inorder, postorder);

        return root;

    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postOrder = new int[]{9, 15, 7, 20, 3};
        TreeNode result = buildTree(inorder,postOrder);
        System.out.println("The Tree is with root : "+ result.val+" left node : "+ result.left.val + " right node : "+result.right.val);

    }
}
