package com.algorithmtron.service;

import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Deque;

@Service
public class MinStackService {
    /**
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     * Implement the MinStack class:
     * MinStack() initializes the stack object.
     * void push(int val) pushes the element val onto the stack.
     * void pop() removes the element on the top of the stack.
     * int top() gets the top element of the stack. If no element is present in the stack, it shall return minimum value Integer
     * int getMin() retrieves the minimum element in the stack. If no element is present in the stack, it shall return minimum value Integer
     *
     */

    Deque<Pair> stack;

    private class Pair {
        int val;
        int min;

        public Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    public MinStackService() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Pair(val, val));
        } else if (val < stack.peek().min) {
            stack.push(new Pair(val,val));
        } else {
            stack.push(new Pair(val, stack.peek().min));
        }
    }

    public void  pop() {
        if (!stack.isEmpty()){
            stack.removeFirst();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        return stack.peek().val;

    }

    public int getMin() {
        if (stack.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        return stack.peek().min;
    }
}
