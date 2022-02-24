package leetcode.p1_100;

import java.util.Arrays;

public class P97 {
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(new P97().isInterleave(s1, s2, s3));
        System.out.println(new P97().isInterleave("ab", "cd", "cdab"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int m = s1.length(), n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 0);
        }
        return isInterleave(s1, s2, s3, 0, 0, dp);
    }

    private boolean isInterleave(String s1, String s2, String s3, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j] == 1;

        if (i == s1.length() && j == s2.length()) return true;
        if (i == s1.length()) return isSame(s2, s3, j, i + j);
        else if (j == s2.length()) return isSame(s1, s3, i, i + j);

        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        char c3 = s3.charAt(i + j);

        if (c1 == c3) {
            dp[i][j] = isInterleave(s1, s2, s3, i + 1, j, dp) ? 1 : -1;
            if (dp[i][j] == 1) return true;
        }
        if (c2 == c3) {
            dp[i][j] = isInterleave(s1, s2, s3, i, j + 1, dp) ? 1 : -1;
            if (dp[i][j] == 1) return true;
        }
        return false;
    }

    private boolean isSame(String s1, String s2, int i, int j) {
        return s1.substring(i).equals(s2.substring(j));
    }
}
