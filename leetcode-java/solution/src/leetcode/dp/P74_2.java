package leetcode.dp;

import java.util.Arrays;

public class P74_2 {

    public static void main(String[] args) {
        System.out.println(new P74_2().minDistance("horse", "ros"));
        System.out.println(new P74_2().minDistance("intention", "execution"));

    }


    public int minDistance(String word1, String word2) {

        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();

        int m = s1.length, n = s2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int replace = dp[i - 1][j - 1] + 1;
                    int del = dp[i - 1][j] + 1;
                    int insert = dp[i][j - 1] + 1;
                    dp[i][j] = Math.min(replace, Math.min(del, insert));
                }
            }
        }

        return dp[m][n];


    }


}
