package com.company.stack;

import java.util.Stack;

interface MinStack {
    public void push(int number);

    public int pop();

    public int getMin();
}

/**
 * All the operations of MinStack should be constant value time complexity. O(1)
 */
public class MinStackImplementation implements MinStack {
    private final Stack<Integer> valueStack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    @Override
    public void push(int number) {
        valueStack.push(number);
        if (minStack.empty() || minStack.peek() > number) {
            minStack.push(number);
        }
    }

    @Override
    public int pop() {
        if (minStack.peek().equals(valueStack.peek())) {
            minStack.pop();
        }
        return valueStack.pop();
    }

    @Override
    public int getMin() {
        return minStack.peek();
    }
}