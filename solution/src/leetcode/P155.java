package leetcode;

import java.util.Stack;

public class P155 {
}

class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();


    /**
     * initialize your data structure here.
     */
    public MinStack() {


    }

    public void push(int x) {
        stack.push(x);
        int min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        minStack.push(Math.min(min,x));

    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }

    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;

    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }
}
