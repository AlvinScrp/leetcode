package leetcode_contest.weekly_190;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class P4_5419 {


//    public static class P {
//        public int i;
//        public int j;
//
//        private P(int i, int j) {
//            this.i = i;
//            this.j = j;
//        }
//
//        static P create(int i, int j) {
//            return new P(i, j);
//        }
//
//    }

    public static void main(String[] args) {
        //972
        System.out.println(new P4_5419().maxDotProduct(
                new int[]{13, -7, 12, -15, -7, 8, 3, -7, -5, 13, -15, -8, 5, 7, -1, 3, -11, -12, 2, -12},
                new int[]{-1, 13, -4, -2, -13, 2, -4, 6, -9, 13, -8, -3, -9}));
////
//        System.out.println(new P4_5419().maxDotProduct(
//                new int[]{3, -2},
//                new int[]{2, -6, 7}));
//
//        System.out.println(new P4_5419().maxDotProduct(
//                new int[]{-1, -1},
//                new int[]{1, 1}));
//        System.out.println(new P4_5419().maxDotProduct(
//                new int[]{2, 1, -2, 5},
//                new int[]{3, 0, -6}));

        System.out.println(new P4_5419().maxDotProduct(
                new int[]{1, 3, -2, 5, 7},
                new int[]{5, -4, 3, 2, 1}
        ));
        System.out.println(new P4_5419().maxDotProduct(
                new int[]{-5, 3, -5, -3, 1},
                new int[]{-2, 4, 2, 5, -5}
        ));
        System.out.println(new P4_5419().maxDotProduct(
                new int[]{-1, -1},
                new int[]{1, 1}
        ));

    }


    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = nums1[i] * nums2[j];
                dp[i][j] = Math.max(
                        num + Math.max(num(dp, i - 1, j - 1), 0),
                        Math.max(num(dp, i - 1, j), num(dp, i, j - 1))
                );
            }
        }
        return dp[m - 1][n - 1];
    }

    public int num(int[][] dp, int i, int j) {
        if (i >= 0 && j >= 0) return dp[i][j];
        return Integer.MIN_VALUE;
    }
}
