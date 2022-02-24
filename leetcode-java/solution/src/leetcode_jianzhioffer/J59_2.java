package leetcode_jianzhioffer;

import java.util.*;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 */
public class J59_2 {
}


class MaxQueue {

    private Queue<Integer> queue;
    private Deque<Integer> maxDeque;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxDeque = new ArrayDeque<>();
    }

    public int max_value() {
        if (maxDeque.isEmpty()) return -1;
        return maxDeque.getFirst();

    }

    public void push_back(int value) {
        queue.offer(value);
        while (!maxDeque.isEmpty() && maxDeque.getLast() < value) {
            maxDeque.removeLast();
        }
        maxDeque.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int value = queue.poll();
        if (!maxDeque.isEmpty() && maxDeque.getFirst() == value) {
            maxDeque.removeFirst();
        }
        return value;

    }
}
