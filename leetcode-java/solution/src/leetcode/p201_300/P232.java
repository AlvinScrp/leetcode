package leetcode.p201_300;

import java.util.LinkedList;

public class P232 {
}
class MyQueue {

    private LinkedList<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        queue.addLast(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
      return   queue.pollFirst();

    }

    /** Get the front element. */
    public int peek() {
        return queue.peekFirst();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();

    }
}
