package leetcode.dp;

import java.util.Arrays;

public class P1143 {

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length(), n = text2.length();
        if (m == 0 || n == 0) return 0;
//
        int[][] dp = new int[m + 1][n+1];
        Arrays.fill(dp[0], 0);
        for (int i = 0; i <= m; i++) dp[i][0]=0;
        for (int j = 0; j <= n; j++) dp[0][j]=0;


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = text1.charAt(i-1), c2 = text2.charAt(j-1);
                if (c1 == c2) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];


//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, 0);
//        for (int i = 1; i <= m; i++) {
//            int pre1 = 0, pre2 = 0;
//            for (int j = 1; j <= n; j++) {
//                pre2 = dp[j];
//                char c1 = text1.charAt(i), c2 = text2.charAt(j);
//                if (c1 == c2) {
//                    dp[j] = pre1 + 1;
//                } else {
//                    dp[j] = Math.max(dp[j - 1], dp[j]);
//                }
//                pre1 = pre2;
//
//            }
//
//        }
//        return dp[n];


    }
}
