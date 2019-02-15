package com.java.stacks_queues;

import java.util.Stack;

/*
Given a list of daily temperatures T, return a list such that, for each day in the input,
tells you how many days you would have to wait until a warmer temperature.
If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 */
public class DailyTemperatures {

    private static int[] dailyTemperature(int[] temperatures){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i< temperatures.length; i++) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temp = {71,73,74,70,69,75};
        int[] result = dailyTemperature(temp);
        for(Integer i : result){
            System.out.print(i+ " ");
        }
    }
}
