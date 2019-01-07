package com.java.linkedlist;
/*
Given a Linked List and a number n, write a function that returns the value at the n’th node from end of the Linked List.

Ex : 1>2>3>4>6>8>10 | k = 3 ; so 3rd node from last is 6
 */

public class KthToLastElement {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

        //Approach 1 : using length ,
        // 1) Calculate the length of Linked List. Let the length be len.
        //2) Print the (len – n)th node from the begining of the Linked List.
        //Time Complexity: O(n) where n is the length of linked list.
        static void findKthToLastElement(Node head,int n) {
            Node current = head;
            int len = 0;
            while (current != null){
                current = current.next;
                len++;
            }
            if(len < n) return;
            current = head;

            for(int i = 0; i<len -n;i++){
                current = current.next;
            }
            System.out.println(current.data);
        }

        static void printKthtoLastElementRunner(Node head, int n){
        Node current = head;
        Node reference = head;
        int count =0;
        if(head != null){
            while(count < n){
                if(reference == null) return;

                reference = reference.next;
                count++;
            }
            while(reference != null){
                current = current.next;
                reference = reference.next;
            }
            System.out.println(current.data);
        }
        }

    public static void main(String[] args) {
        KthToLastElement list = new KthToLastElement();
        list.head = new Node(10);
        list.head.next = new Node(12);
        list.head.next.next = new Node(13);
        list.head.next.next.next = new Node(14);
        list.head.next.next.next.next = new Node(15);
        list.head.next.next.next.next.next = new Node(16);
        list.head.next.next.next.next.next.next = new Node(17);
        printKthtoLastElementRunner(head,2);
    }
}
