package com.java.stacks_queues;

// Implementing N stack of integers using single array
// REFERENCE : https://www.youtube.com/watch?v=DxW7VAsdX0o

public class KStackUsingOneArray {

    int[] topOfStack;
    int[] stackData;
    // This array serves 2 purposes : 1. At a given node what next available index is which is notused in stack
    //2. If element is set, it is going to point to the previous index of the stack
    int[] nextIndex;
    int nextAvailable = 0;

    KStackUsingOneArray(int numStacks,int capacity){
        topOfStack = new int[numStacks];
        for (int i = 0; i < topOfStack.length; i++) {
            topOfStack[i] = -1; // initialize it to -1 since they are not pointing to any index
        }
        stackData = new int[capacity];
        nextIndex = new int[capacity];
        for (int i = 0; i < nextIndex.length - 1; i++) {
            nextIndex[i] = i+1;
        }
        nextIndex[nextIndex.length - 1] = -1;
    }
    // topOfStack = [-1,-1,-1]
    // stackData = {0, 0, 0, 0, 0, 0}
    // nextIndex = {1, 2, 3, 4, 5, -1}
    public void push(int stack, int value) {
        if (stack < 0 || stack >= topOfStack.length) {
            throw new IndexOutOfBoundsException();
        }

        if (nextAvailable < 0) return;

        int currentIndex = nextAvailable;
        nextAvailable = nextIndex[currentIndex];
        stackData[currentIndex] = value;
        nextIndex[currentIndex] = topOfStack[stack];
        topOfStack[stack] = currentIndex;
    }

    public int pop(int stack) {
        if (stack < 0 || stack >= topOfStack.length
                || topOfStack[stack] < 0) {
            throw new IndexOutOfBoundsException();
        }

        int currentIndex = topOfStack[stack];
        int value = stackData[currentIndex];
        topOfStack[stack] = nextIndex[currentIndex];
        nextIndex[currentIndex] = nextAvailable;
        nextAvailable = currentIndex;
        return value;
    }

}
