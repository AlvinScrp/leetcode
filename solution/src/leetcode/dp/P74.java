package leetcode.dp;

import java.util.Arrays;

public class P74 {

    public static void main(String[] args) {
        System.out.println(new P74().minDistance("horse", "ros"));
        System.out.println(new P74().minDistance("intention", "execution"));

    }

    char[] s1;
    char[] s2;

    public int minDistance(String word1, String word2) {

        s1 = word1.toCharArray();
        s2 = word2.toCharArray();

        int m = s1.length, n = s2.length;
        dp = new int[m][n];
        for (int[] ints : dp) Arrays.fill(ints, -1);

        int ans = edit(m - 1, n - 1);
        return ans;


    }

    int[][] dp;

    private int edit(int i, int j) {
        if (i < 0 || j < 0) return Math.abs(j - i);

        if (dp[i][j] >= 0) return dp[i][j];
        if (s1[i] == s2[j]) {
            dp[i][j] = edit(i - 1, j - 1);
        } else {
            int replace = edit(i - 1, j - 1) + 1;
            int del = edit(i - 1, j) + 1;
            int insert = edit(i, j - 1) + 1;
            dp[i][j] = Math.min(replace, Math.min(del, insert));
        }
        return dp[i][j];
    }
}
