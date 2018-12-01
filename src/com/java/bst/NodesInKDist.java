package com.java.bst;

import java.util.*;

/*
We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance
K from the target node.  The answer can be returned in any order.



Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation:
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.

         3
        / \
      5     1
     / \   / \
    6   2 0   8
       / \
      7   4
Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.


Note:

The given tree is non-empty.
Each node in the tree has unique values 0 <= node.val <= 500.
The target node is a node in the tree.
0 <= K <= 1000.
 */
public class NodesInKDist {
    static TreeNode root;
    NodesInKDist(){
        root =null;
    }
    public static class TreeNode {
      int val;
      TreeNode left;
       TreeNode right;
      TreeNode(int x) { val = x; }
  }
    static Map<TreeNode, TreeNode> parent;

    /* APPROACH O(N), O(N)

    Intuition

If we know the parent of every node x, we know all nodes that are distance 1 from x.
We can then perform a breadth first search from the target node to find the answer.

Algorithm

We first do a depth first search where we annotate every node with information about it's parent.

After, we do a breadth first search to find all nodes a distance K from the target.

     */
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList();
        queue.add(null);
        queue.add(target);

        Set<TreeNode> seen = new HashSet();
        seen.add(target);
        seen.add(null);

        int dist = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (dist == K) {
                    List<Integer> ans = new ArrayList();
                    for (TreeNode n: queue)
                        ans.add(n.val);
                    return ans;
                }
                queue.offer(null);
                dist++;
            } else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }

        return new ArrayList<Integer>();
    }

    public static void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public static void main(String[] args) {
        NodesInKDist tree = new NodesInKDist();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(1);
        tree.root.left.left = new TreeNode(6);
        tree.root.left.right = new TreeNode(2);
        tree.root.left.right.left = new TreeNode(7);
        tree.root.left.right.right = new TreeNode(4);
        tree.root.right.left = new TreeNode(0);
        tree.root.right.right = new TreeNode(8);
        List<Integer> result = distanceK(root,tree.root.left,2);
        for(Integer i : result){
            System.out.print(i+" ");
        }
    }
}
