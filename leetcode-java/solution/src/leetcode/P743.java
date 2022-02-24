package leetcode;

import java.util.Arrays;

public class P743 {

    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        int MAX = Integer.MAX_VALUE >> 1;
        int[][] p = new int[n][n];
        for (int[] ints : p) Arrays.fill(ints, MAX);
        for (int[] time : times) {
            p[time[0] - 1][time[1] - 1] = time[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist, MAX);
        dist[k - 1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int y = 0; y < n; y++) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; y++) {
                dist[y] = Math.min(dist[y], dist[x] + p[x][y]);
            }
        }
        int result = Arrays.stream(dist).max().getAsInt();
        return result == MAX ? -1 : result;
    }
}
