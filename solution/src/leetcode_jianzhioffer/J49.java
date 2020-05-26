package leetcode_jianzhioffer;

import java.util.*;

public class J49 {
    public static void main(String[] args) {
        System.out.println(new J49().nthUglyNumber(1690));//2123366400
        System.out.println(new J49().nthUglyNumber(10));//2123366400
    }

    /**
     * 丑数必然是由
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[1690];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;

        for (int i = 1; i < n; i++) {
            int v2 = dp[p2] * 2, v3 = dp[p3] * 3, v5 = dp[p5] * 5;
            int v = Math.min(v2, Math.min(v3, v5));
            if (v == v2) p2++;
            if (v == v3) p3++;
            if (v == v5) p5++;
            dp[i] = v;
        }
        return dp[n - 1];

    }

//    public int nthUglyNumber(int n) {
//
//        PriorityQueue<Long> queue = new PriorityQueue();
//        queue.offer(1L);
//        int count = 0;
//        long ans = 1;
//        while (!queue.isEmpty()) {
//            long val = queue.poll();
//            while (!queue.isEmpty() && queue.peek() == val) {
//                queue.poll();
//            }
//            queue.offer(val * 2);
//            queue.offer(val * 3);
//            queue.offer(val * 5);
//            count++;
//            if (count == n) {
//                ans = val;
//                break;
//            }
//
//        }
//        return (int) ans;
//
//    }
}
