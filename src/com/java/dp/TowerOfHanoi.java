package com.java.dp;
/*
Tower of Hanoi is a mathematical puzzle. It consists of three poles and a number of disks of different sizes which can slide onto any poles. The puzzle starts with the disk in a neat stack in ascending order of size in one pole, the smallest at the top thus making a conical shape. The objective of the puzzle is to move all the disks from one pole (say ‘source pole’) to another pole (say ‘destination pole’) with the help of third pole (say auxiliary pole).

The puzzle has the following two rules:

      1. You can’t place a larger disk onto smaller disk
      2. Only one disk can be moved at a time

We have also seen that, for n disks, total 2n – 1 moves are required.

Iterative Algorithm:

1. Calculate the total number of moves required i.e. "pow(2, n)
   - 1" here n is number of disks.
2. If number of disks (i.e. n) is even then interchange destination
   pole and auxiliary pole.
3. for i = 1 to total number of moves:
     if i%3 == 1:
    legal movement of top disk between source pole and
        destination pole
     if i%3 == 2:
    legal movement top disk between source pole and
        auxiliary pole
     if i%3 == 0:
        legal movement top disk between auxiliary pole
        and destination pole
 */
public class TowerOfHanoi {
        static class Stack{
            int capacity;
            int top;
            int array[];
        }

        static Stack createStack(int capacity){
            Stack stack = new Stack();
            stack.capacity = capacity;
            stack.top = -1;
            stack.array = new int[capacity];
            return stack;
        }

        static boolean isFull(Stack stack){
            return (stack.top == stack.capacity - 1);
        }

        static boolean isEmpty(Stack stack){
            return (stack.top == -1);
        }

        static void push(Stack stack, int item){
            if(isFull(stack)) return;
            stack.array[++stack.top] = item;
        }

        static int pop(Stack stack){
            if(isEmpty(stack))
                return Integer.MIN_VALUE;
            return stack.array[stack.top--];
        }

        static void moveDisksBetweenPoles(Stack src, Stack dest, char s, char d){
            int pole1TopDisk = pop(src);
            int pole2TopDisk = pop(dest);

            if(pole1TopDisk == Integer.MIN_VALUE){
                push(src,pole2TopDisk);
                moveDisk(d,s,pole2TopDisk);

            }else if(pole2TopDisk == Integer.MIN_VALUE){
                push(dest,pole1TopDisk);
                moveDisk(s,d,pole1TopDisk);

            }else if(pole1TopDisk > pole2TopDisk){
                push(src,pole1TopDisk);
                push(src,pole2TopDisk);
                moveDisk(d,s,pole2TopDisk);
            }else{
                push(dest,pole2TopDisk);
                push(dest,pole1TopDisk);
                moveDisk(s,d,pole1TopDisk);

            }
        }

    private static void moveDisk(char from, char to, int disk) {
        System.out.println("Move the disk "+disk+" from "+from+" to "+to);
    }

    static void tohIterative(int num_of_disks, Stack src, Stack aux, Stack dest){
            int i, total_num_of_moves;
            char s = 'S', d = 'D', a = 'A';

            //If the number of disks is even interchange destination and auxiliary poles
        if(num_of_disks%2 == 0){
            char temp = d;
            d = a;
            a = temp;
        }
        total_num_of_moves = (int) (Math.pow(2, num_of_disks) - 1);

        // larger disks will be pushed first
        for(i = num_of_disks; i >= 1; i--)
            push(src,i);

        for(i = 1; i<total_num_of_moves; i++){
            if(i % 3 == 1){
                moveDisksBetweenPoles(src, dest, s, d);
            }else if(i % 3 == 2){
                moveDisksBetweenPoles(src, aux, s, a);
            }else if(i % 3 == 0){
                moveDisksBetweenPoles(aux,dest, a, d);
            }
        }
    }

    public static void main(String[] args) {
        int num_of_disks = 3;
        TowerOfHanoi toh = new TowerOfHanoi();
        Stack src, dest, aux;

        // Create three stacks of size 'num_of_disks'
        // to hold the disks
        src = toh.createStack(num_of_disks);
        dest = toh.createStack(num_of_disks);
        aux = toh.createStack(num_of_disks);

        toh.tohIterative(num_of_disks,src,aux,dest);
    }
}
