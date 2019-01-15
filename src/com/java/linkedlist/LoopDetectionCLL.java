package com.java.linkedlist;

/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list,
we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
If pos is -1, then there is no cycle in the linked list.

 */
public class LoopDetectionCLL {

    static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head.next;
        //detect the loop
        while (fast != null && fast.next != null && slow != fast) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null || fast.next == null) return null;
        ListNode p = fast.next, finder = head;
        //iterate from head using finder and loop once for each finder
        //when finder matcher pointer in loop, that is the starting node
        for (; ; ) {
            if (finder == fast) return finder;
            while (p != fast) {
                if (p == finder)
                    return finder;
                p = p.next;
            }
            p = fast.next;
            finder = finder.next;
        }
    }

    public static void main(String[] args) {
        LoopDetectionCLL list1 = new LoopDetectionCLL();
        list1.head = new ListNode(6);
        list1.head.next = new ListNode(5);
        list1.head.next.next = new ListNode(8);
        list1.head.next.next.next = new ListNode(4);
        list1.head.next.next.next.next = new ListNode(8);
        // creating loop for testing
        list1.head.next.next.next.next.next = list1.head.next.next.next;
        System.out.println(detectCycle(head).val);
    }
}
