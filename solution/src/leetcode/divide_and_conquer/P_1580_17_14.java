package leetcode.divide_and_conquer;

import java.util.PriorityQueue;

public class P_1580_17_14 {

    public int[] smallestK(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : arr) {
            queue.add(i);
            if (queue.size() == k + 1) queue.poll();
        }
        int[] ans = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            ans[i++] = queue.poll();
        }
        return ans;

    }
}
