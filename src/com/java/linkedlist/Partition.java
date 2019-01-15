package com.java.linkedlist;

public class Partition {
    static ListNode head;
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int d){
            this.val = d;
            next = null;
        }
    }
    static ListNode partition(ListNode head, int x) {

        // before and after are the two pointers used to create the two list
        // before_head and after_head are used to save the heads of the two lists.
        // All of these are initialized with the dummy nodes created.
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {

            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }

            // move ahead in the original list
            head = head.next;
        }

        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;

        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = after_head.next;

        return before_head.next;
    }
    static void printList()
    {
        ListNode tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.val+" ");
            tnode = tnode.next;
        }
    }

    public static void main(String[] args) {
        Partition list = new Partition();
        list.head = new ListNode(10);
        list.head.next = new ListNode(12);
        list.head.next.next = new ListNode(13);
        list.head.next.next.next = new ListNode(14);
        list.head.next.next.next.next = new ListNode(15);
        list.head.next.next.next.next.next = new ListNode(16);
        list.head.next.next.next.next.next.next = new ListNode(11);
        System.out.println(partition(head,13));
        printList();
    }
}
