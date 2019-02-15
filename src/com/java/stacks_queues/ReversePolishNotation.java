package com.java.stacks_queues;

import java.util.Stack;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
 */
public class ReversePolishNotation {

    private static int evaluateRPN(String[] tokens){
        int a,b;
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            switch(s){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(b - a);
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;

                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();

    }

    public static void main(String[] args) {
        String[] tokens = {"2","3", "*", "1", "+"};
        System.out.println(evaluateRPN(tokens));
    }
}
