package com.java.linkedlist;

public class DeleteNode {
    static Node head;
    static class Node{
        int data;
        Node next;
         Node(int d){
           data = d;
           next = null;
        }
    }

    static void deleteNode(int key){
        Node previous = null; Node current = head;

        if(current != null && current.data == key){
            head = current.next;
            return;
        }

        while(current != null && current.data != key){
            previous = current;
            current = current.next;
        }

        if(current == null) return;

        previous.next = current.next;
    }
    static void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
    }
    public static void main(String[] args) {
        DeleteNode list = new DeleteNode();
        list.head = new Node(10);
        list.head.next = new Node(12);
        list.head.next.next = new Node(13);
        list.head.next.next.next = new Node(14);
        list.head.next.next.next.next = new Node(15);
        list.head.next.next.next.next.next = new Node(16);
        list.head.next.next.next.next.next.next = new Node(17);

        deleteNode(17);
        printList();
    }
}
