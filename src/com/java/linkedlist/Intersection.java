package com.java.linkedlist;

/*
Write a program to find the node at which the intersection of two singly linked lists begins.

A:          a1 -> a2
                    \
                      c1 -> c2 -> c3
                    /
B:     b1 -> b2 -> b3

OP : c1

 */
public class Intersection {
    static ListNode head;
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
    First calculate the length of two lists and find the difference.
    Then start from the longer list at the diff offset, iterate though 2 lists and find the node.
     */

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode p1 = headA, p2 = headB;
        if (p1 == null || p2 == null)
            return null;

        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }

        int diff = 0;
        p1 = headA;
        p2 = headB;

        if (len1 > len2) {
            diff = len1 - len2;
            int i = 0;
            while (i < diff) {
                p1 = p1.next;
                i++;
            }
        } else {
            diff = len2 - len1;
            int i = 0;
            while (i < diff) {
                p2 = p2.next;
                i++;
            }
        }

        while (p1 != null && p2 != null) {
            if (p1.val == p2.val) {
                return p1;
            } else {

            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }

    public static void main(String[] args) {
        Intersection list1 = new Intersection();
        list1.head = new ListNode(6);
        list1.head.next = new ListNode(5);
        list1.head.next.next = new ListNode(8);
        list1.head.next.next.next = new ListNode(4);
        list1.head.next.next.next.next = new ListNode(4);

        Intersection list2 = new Intersection();
        // creating seconnd list
        list2.head = new ListNode(8);
        list2.head.next = new ListNode(7);

        System.out.println(getIntersectionNode(list1.head,list2.head).val);

    }
}

