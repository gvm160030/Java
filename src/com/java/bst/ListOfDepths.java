package com.java.bst;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListOfDepths {
    static Node root,left,right;
    static class ListNode{
        int data;
        ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Node {

        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static ArrayList<LinkedList<Node>> levelOrderTraversal(Node root) {
        ArrayList<LinkedList<Node>> result = new ArrayList<>();
        LinkedList<Node> current = new LinkedList<Node>();
        if (root != null) {
            current.add(root);
            while (current.size() > 0) {
                result.add(current); // add previous level
                LinkedList<Node> parent = current;
                current = new LinkedList<Node>();
                for (Node n : parent) {
                    // Visits the children
                    if (n.left != null) {
                        current.add(n.left);
                    }
                    if (n.right != null) {
                        current.add(n.right);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListOfDepths tree = new ListOfDepths();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        System.out.println(levelOrderTraversal(root).size());

    }
}
