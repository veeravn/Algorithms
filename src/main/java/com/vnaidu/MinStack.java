package com.vnaidu;

import lombok.Getter;

import java.util.Stack;

public class MinStack {

    @Getter
    int min = Integer.MAX_VALUE;
    Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack<>();
    }

    public void push(int val) {
        if(val <= min){
            minStack.push(min);
            min=val;
        }
        minStack.push(val);
    }

    public void pop() {
        if(minStack.pop()==min){
            min=minStack.pop();
        }
    }

    public int top() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
