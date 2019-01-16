package com.java.linkedlist;

import java.util.HashSet;

/*
Write a removeDuplicates() function which takes a list and deletes any duplicate nodes from the list.
The list is not sorted.
For example if the linked list is 12->11->12->21->41->43->21 then removeDuplicates() should convert the list to
12->11->21->41->43.
 */
public class RemoveDups {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // 2 pointer method | TC : O(N2) , SC : O(1)
    static void removeDuplicatesRunner(Node head) {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        printList(head);
    }

    // TC : O(N) ;
    static void removeDuplicatesHashset(Node node) {
        Node current = node;
        HashSet<Integer> set = new HashSet<Integer>();
        Node previous = null;
        while(current != null){
            if(set.contains(current.data)){
                previous.next = current.next;
            } else {
                set.add(current.data);
                previous = current;
            }
            current = current.next;
        }
        printList(head);
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        RemoveDups list = new RemoveDups();
        list.head = new Node(10);
        list.head.next = new Node(12);
        list.head.next.next = new Node(11);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = new Node(12);
        list.head.next.next.next.next.next = new Node(11);
        list.head.next.next.next.next.next.next = new Node(10);

        removeDuplicatesHashset(head);
    }
}
