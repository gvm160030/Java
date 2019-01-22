package com.java.linkedlist;

import java.util.Stack;

/*
You are given two non-empty linked lists representing two non-negative integers.
The most significant digit comes first and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */

public class SumListII {

        static Node head1, head2;

        static class Node {

            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }


    static Node addTwoNumbers(Node l1, Node l2) {
        Stack<Node> l1Stack = new Stack<>();

        while(l1 != null) {
            l1Stack.push(l1);
            l1 = l1.next;
        }

        Stack<Node> l2Stack = new Stack<>();

        while(l2 != null) {
            l2Stack.push(l2);
            l2 = l2.next;
        }

        int carry = 0;
        Node dummy = null;

        while(!l1Stack.isEmpty() || !l2Stack.isEmpty() ||  carry != 0) {
            int f = l1Stack.isEmpty() ? 0 : l1Stack.pop().data;
            int s = l2Stack.isEmpty() ? 0 : l2Stack.pop().data;

            int t = f + s + carry;

            Node newNode = new Node(t % 10);

            newNode.next = dummy;
            dummy = newNode;
            carry = t/10;

        }

        return dummy;

    }


        void printList(Node head) {
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
            System.out.println("");
        }

        public static void main(String[] args) {
            SumListII list = new SumListII();

            // creating first list
            list.head1 = new Node(6);
            list.head1.next = new Node(5);
            list.head1.next.next = new Node(8);
            list.head1.next.next.next = new Node(4);
            list.head1.next.next.next.next = new Node(4);
            System.out.print("First List is ");
            list.printList(head1);

            // creating seconnd list
            list.head2 = new Node(8);
            list.head2.next = new Node(8);
            System.out.print("Second List is ");
            list.printList(head2);

            // add the two lists and see the result
            Node rs = list.addTwoNumbers(head1, head2);
            System.out.print("Resultant List is ");
            list.printList(rs);
        }
    }

