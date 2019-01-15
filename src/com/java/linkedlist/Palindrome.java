package com.java.linkedlist;


/*
Given a singly linked list, determine if it is a palindrome
 */
public class Palindrome {
    static ListNode head;
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int data){
            this.val = data;
            next = null;
        }
    }
    // APPROACH 1
    // We can create a new list in reversed order and then compare each node. The time and space are O(n).

    static boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;

        ListNode previous = head;
        ListNode current = previous.next;

        head.next = null;
        while (previous != null && current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        ListNode p1 = head;
        ListNode p2 = previous;

        while(p1!=null){
            if(p1.val != p2.val)
                return false;

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    // APPROACH 2 : Break and reverse the second half of the linked list

    static boolean isPalindromeII(ListNode head) {

        if(head == null || head.next==null)
            return true;

        //find list center
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        //reverse second part of the list
        ListNode previous = secondHead;
        ListNode current = previous.next;

        while(previous!=null && current!=null){
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        secondHead.next = null;

        //compare two sublists now
        ListNode p = (current==null?previous:current);
        ListNode q = head;
        while(p!=null){
            if(p.val != q.val)
                return false;

            p = p.next;
            q = q.next;

        }

        return true;
    }

    public static void main(String[] args) {
        Palindrome list = new Palindrome();
        list.head = new ListNode(1);
        list.head.next = new ListNode(5);
        list.head.next.next = new ListNode(5);
        list.head.next.next.next = new ListNode(1);
        System.out.println(isPalindromeII(head));
    }
}
