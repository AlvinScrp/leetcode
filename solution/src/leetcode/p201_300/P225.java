package leetcode.p201_300;

import java.util.LinkedList;

public class P225 {


}

class MyStack {

//    使用队列实现栈的下列操作：
//
//    push(x) -- 元素 x 入栈
//    pop() -- 移除栈顶元素
//    top() -- 获取栈顶元素
//    empty() -- 返回栈是否为空

    private LinkedList<Integer> queue = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.addLast(x);

    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return empty() ? -1 : queue.pollLast();

    }

    /**
     * Get the top element.
     */
    public int top() {

        return empty() ? -1 : queue.peekLast();

    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();

    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
