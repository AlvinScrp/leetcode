package leetcode.p201_300;

import java.util.PriorityQueue;

public class P295 {
}

class MedianFinder {

    PriorityQueue<Integer> smalls = new PriorityQueue<>((v1, v2) -> v2 - v1);
    PriorityQueue<Integer> bigs = new PriorityQueue<>();

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {


        if (!smalls.isEmpty() && num <= smalls.peek()) {
            smalls.offer(num);
        } else {
            bigs.offer(num);
        }
        while (bigs.size() > smalls.size()) {
            smalls.offer(bigs.poll());
        }
        while (smalls.size() - bigs.size() > 1) {
            bigs.offer(smalls.poll());
        }

    }

    public double findMedian() {
        if (bigs.size() == smalls.size()) return (bigs.peek() + smalls.peek()) / 2.0;
        return smalls.peek();

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */