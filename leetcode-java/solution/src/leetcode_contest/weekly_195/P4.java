package leetcode_contest.weekly_195;

import java.util.Deque;
import java.util.LinkedList;

public class P4 {

    public static void main(String[] args) {
        System.out.println();
        System.out.println(findMaxValueOfEquation(new int[][]{{1, 3}, {2, 0}, {5, 10}, {6, -10}}, 1));

    }

    public static int findMaxValueOfEquation(int[][] points, int k) {

        Deque<Integer> deque = new LinkedList<>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];

            while (!deque.isEmpty() && point[0] - points[deque.getFirst()][0] > k) {
                deque.removeFirst();
            }
            if (!deque.isEmpty()) {
                int[] first = points[deque.getFirst()];
                int val = point[1] + point[0] + first[1] - first[0];
                max = Math.max(max, val);
            }

            int value = point[1] - point[0];
            while (!deque.isEmpty()) {
                int[] last = points[deque.getLast()];
                if (last[1] - last[0] <= value) {
                    deque.removeLast();
                } else {
                    break;
                }
            }
            deque.addLast(i);
        }
        return max;

    }


}
