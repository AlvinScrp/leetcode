package leetcode_contest.weekly_192;

import java.util.Arrays;

public class P4 {

    public static void main(String[] args) {
        System.out.println(new P4().minCost(
                new int[]{0, 0, 0, 0, 0},
                new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}},
                5, 2, 3));

        System.out.println(new P4().minCost(
                new int[]{0, 0, 0, 0, 0},
                new int[][]{{1, 10}, {10, 1}, {1, 10}, {10, 1}, {1, 10}},
                5, 2, 5));

        System.out.println(new P4().minCost(
                new int[]{0, 2, 1, 2, 0},
                new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}},
                5, 2, 3));

        System.out.println(new P4().minCost(
                new int[]{2, 2, 1},
                new int[][]{{1, 1}, {3, 4}, {4, 2}},
                3, 2, 2));
    }


    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {

        //第i个房子，target为j,颜色为k,的最小花费
        int[][][] dp = new int[m + 1][target + 1][n];

        for (int i = 1; i <= m; i++) {
            int color = houses[i - 1] - 1;
            boolean colored = color >= 0;

            for (int j = 1; j <= target && j <= i; j++) {
                for (int k = 0; k < n; k++) {
                    if (colored && k != color) {
                        dp[i][j][k] = -1;
                        continue;
                    }
                    int costt = (colored && k == color) ? 0 : cost[i - 1][k];
                    if (j == 1) {
                        if (dp[i - 1][j][k] < 0) {
                            dp[i][j][k] = -1;
                        } else {
                            dp[i][j][k] = dp[i - 1][j][k] + costt;
                        }

                    } else {
                        int minCost = Integer.MAX_VALUE;
                        for (int k2 = 0; k2 < n; k2++) {
                            if (k2 != k) {
                                if (dp[i - 1][j - 1][k2] >= 0) {
                                    minCost = Math.min(dp[i - 1][j - 1][k2], minCost);
                                }
                            } else if (j <= i - 1) {
                                if (dp[i - 1][j][k2] >= 0) {
                                    minCost = Math.min(dp[i - 1][j][k2], minCost);
                                }
                            }
                        }
                        if (minCost == Integer.MAX_VALUE) {
                            dp[i][j][k] = -1;
                        } else {
                            dp[i][j][k] = minCost + costt;
                        }
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            if (dp[m][target][k] >= 0) {
                ans = Math.min(dp[m][target][k], ans);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;


    }


//    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
//
//        //第i个房子，颜色为j,target为k的最小花费
//        int[][][] dp = new int[m + 1][n][target + 1];
//
//        for (int j = 0; j < dp[0].length; j++) {
//            Arrays.fill(dp[0][j], Integer.MAX_VALUE);
//        }
//
//        for (int j = 0; j < cost[0].length; j++) {
//            dp[0][j][0] = cost[0][j];
//            Arrays.fill(dp[0][j], 0);
//        }
//
////        for (int j = 0; j < cost[0].length; j++) {
////            dp[0][j][1] = cost[0][j];
////        }
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 0; j < cost[i].length; j++) {
//                for (int k = 1; k <= target; k++) {
//                    if (k == 1) {
//
//                    }
//
//                    int minCost = Integer.MAX_VALUE;
//                    for (int j2 = 0; j2 < n; j2++) {
//                        if (j2 != j) {
//                            minCost = Math.min(dp[i - 1][j2][k - 1], minCost);
//                        } else {
//                            minCost = Math.min(dp[i - 1][j2][k], minCost);
//                        }
//                    }
//                    dp[i][j][k] = minCost + cost[i][j];
//                }
//            }
//        }
//
//        int ans = Integer.MAX_VALUE;
//
//        for (int j = 0; j < n; j++) {
//            ans = Math.min(dp[m - 1][j][target], ans);
//        }
//        return ans;
//
//
//    }

    /**
     * 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
     * 输出：9
     * 解释：房子涂色方案为 [1,2,2,1,1]
     * 此方案包含 target = 3 个街区，分别是 [{1}, {2,2}, {1,1}]。
     * 涂色的总花费为 (1 + 1 + 1 + 1 + 5) = 9。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/paint-house-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     //     * @param args
     */


//    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
//
//        //第i个房子，target为j,颜色为k,的最小花费
//        int[][][] dp = new int[m + 1][target + 1][n];
//        for (int i = 1; i <= m; i++) {
//            for (int k = 0; k < n; k++) {
//                dp[i][1][k] = dp[i - 1][1][k] + cost[i - 1][k];
//            }
//        }
//
//        for (int i = 2; i <= m; i++) {
//            for (int j = 2; j <= target && j <= i; j++) {
//                for (int k = 0; k < n; k++) {
//                    int minCost = Integer.MAX_VALUE;
//                    for (int k2 = 0; k2 < n; k2++) {
//                        if (k2 != k) {
//                            minCost = Math.min(dp[i - 1][j - 1][k2], minCost);
//                        } else if (j <= i - 1) {
//                            minCost = Math.min(dp[i - 1][j][k2], minCost);
//                        }
//                    }
//                    dp[i][j][k] = minCost + cost[i - 1][k];
//                }
//            }
//        }
//
//        int ans = Integer.MAX_VALUE;
//        for (int k = 0; k < n; k++) {
//            ans = Math.min(dp[m][target][k], ans);
//        }
//        return ans;
//
//
//    }
}
