package com.vnaidu;

public class CustomStack extends Base {
    private final int[] stack;
    private final int[] increment;
    private int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        increment = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if (top < stack.length - 1) {
            stack[++top] = x;
        }
    }

    public int pop() {
        if (top == -1) return -1;
        int result = stack[top] + increment[top];
        if (top > 0) {
            increment[top - 1] += increment[top];
        }
        increment[top] = 0;
        top--;
        return result;
    }

    public void increment(int k, int val) {
        int limit = Math.min(k - 1, top);
        if (limit >= 0) {
            increment[limit] += val;
        }
    }
}

