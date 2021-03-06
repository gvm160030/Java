package com.java.stacks_queues;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 */

public class MinStack {
    static Elem top;

    MinStack(){

    }
    /*
    To make constant time of getMin(), we need to keep track of the minimum element for each element in the stack.
    Define an element class that holds element value, min value, and pointer to elements below it.
     */

    static class Elem{
        int min;
        int value;
        Elem next;

        Elem(int value, int min){
            this.value = value;
            this.min = min;
        }
    }
    static void push(int x){
        if(top == null){
            top = new Elem(x,x);
        }else{
            Elem e = new Elem(x, Math.min(top.min,x));
            e.next = top;
            top = e;
        }
    }

    static void pop(){
        if(top == null) return;
        Elem temp = top.next;
        top.next = null;
        top = temp;
    }

    public int top() {
        if(top == null)
            return -1;
        return top.value;
    }

    public int getMin() {
        if(top == null)
            return -1;
        return top.min;
    }

}
