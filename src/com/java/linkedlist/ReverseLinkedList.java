package com.java.linkedlist;

public class ReverseLinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node reverseIterative(Node head){

            if (head == null || head.next == null)
                return head;

            Node previous = head;
            Node current = previous.next;

            head.next = null;
            while (previous != null && current != null) {
                Node nextNode = current.next;
                current.next = previous;
                previous = current;
                current = nextNode;
            }
            return previous;
    }
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(10);
        list.head.next = new Node(5);
        list.head.next.next = new Node(18);
        list.head.next.next.next = new Node(1);
        printList(head);
        Node node = reverseIterative(head);
        printList(node);
    }
}
