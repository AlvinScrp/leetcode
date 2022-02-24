package leetcode_contest.biweekly_29;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class P4 {
    public static void main(String[] args) {
        System.out.println(minNumberOfSemesters(5,new int[][]{{1,5},{2,4},{3,4},{4,5}},2));
    }
    public static int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] count = new int[n];
        for (int[] dependency : dependencies) {
            graph[dependency[0] - 1].add(dependency[1] - 1);
            count[dependency[1] - 1]++;
        }
        PriorityQueue<Integer> deque = new PriorityQueue<>((a, b) -> count[b] - count[a]);
        for (int i = 0; i < n; i++) {
            if (count[i] == 0) {
                deque.add(i);
            }
        }
        int c = 0;
        while (!deque.isEmpty()) {
            ArrayList<Integer> next = new ArrayList<>();
            for (int i = 0; !deque.isEmpty() && i < k; i++) {
                int j = deque.remove();
                for (int l : graph[j]) {
                    count[l]--;
                    if (count[l] == 0) {
                        next.add(l);
                    }
                }
            }
            deque.addAll(next);
            c++;
        }
        return c;
    }
}
