package leetcode_contest.weekly_197;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P3 {

    public static void main(String[] args) {
//        n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
        System.out.println(maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.2}, 0, 2));
        System.out.println(maxProbability(5,
                new int[][]{{1, 4}, {2, 4}, {0, 4}, {0, 3}, {0, 2}, {2, 3}},
                new double[]{0.37, 0.17, 0.93, 0.23, 0.39, 0.04}, 3, 4));

    }


    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        double[] d = new double[n];
        boolean[] vist = new boolean[n];
        d[start] = 1.0d;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> -d[o]));

        queue.add(start);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (vist[index]) continue;
            vist[index] = true;

            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                int to = edge[0] == index ? edge[1] : (edge[1] == index ? edge[0] : -1);
                if (to >= 0 && !vist[to]) {
                    d[to] = Math.max(d[to], d[index] * succProb[i]);
                    queue.add(to);
                }
            }
        }
        return d[end];
    }


}
