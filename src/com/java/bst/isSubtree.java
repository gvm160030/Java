package com.java.bst;
/*
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.

Time complexity : O(m*n)O(m∗n). In worst case(skewed tree) traverse function takes O(m*n)O(m∗n) time.

Space complexity : O(n)O(n). The depth of the recursion tree can go upto nn. nn refers to the number of nodes in ss.
 */
public class isSubtree {
    static TreeNode root,left,right;

    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int d) {
            val = d;
            left = right = null;
        }
    }
    static boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    static boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }
    static boolean traverse(TreeNode s,TreeNode t)
    {
        return  s!= null && (equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }

    public static void main(String[] args) {
        //isSubtree tree = new isSubtree();
        TreeNode T = new TreeNode(1);
        T.left = new TreeNode(2);
        T.right = new TreeNode(3);
        T.left.left = new TreeNode(4);
        T.left.right = new TreeNode(5);

        T.right.left = new TreeNode(6);
        T.right.right = new TreeNode(7);

       // isSubtree subTree = new isSubtree();
        TreeNode S = new TreeNode(3);
        S.left = new TreeNode(6);
        S.right = new TreeNode(7);

        System.out.println(isSubtree(T,S));

    }
}
