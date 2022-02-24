package leetcode.dp;

import java.util.Arrays;

public class P1039 {

    public static void main(String[] args) {
//        System.out.println(new P1039().minScoreTriangulation(new int[]{3, 7, 4, 5}));
        System.out.println(new P1039().minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5}));
    }

    public int minScoreTriangulation(int[] A) {

        int n = A.length;
        if (n < 3) return 0;
        int[][] dp = new int[n][n];
        for (int step = 2; step < n; step++) {
            for (int i = 0; i < n && i + step < n; i++) {
                int j = i + step;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], A[i] * A[k] * A[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
