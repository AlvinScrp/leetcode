package leetcode.dp;

import java.util.Arrays;

public class P516 {


    public static void main(String[] args) {
        System.out.println(new P516().longestPalindromeSubseq("bbbab"));
    }


//    int[][] dp;
//
//    public int longestPalindromeSubseq(String s) {
//        dp = new int[s.length()][s.length()];
//        for (int[] ints : dp) {
//            Arrays.fill(ints, -1);
//        }
//        return subSeq(s, 0, s.length() - 1);
//    }
//
//    private int subSeq(String s, int i, int j) {
//
//        if (dp[i][j] == -1) {
//            if (i == j) dp[i][j] = 1;
//            else if (i + 1 == j) dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
//            else if (s.charAt(i) == s.charAt(j)) {
//                dp[i][j] = subSeq(s, i + 1, j - 1) + 2;
//            } else {
//                dp[i][j] = Math.max(subSeq(s, i + 1, j), subSeq(s, i, j - 1));
//            }
//        }
//        return dp[i][j];
//    }


    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int step = 0; step < n; step++) {
            for (int i = 0; i < n && i + step < n; i++) {
                int j = i + step;
                if (step == 0) dp[i][j] = 1;
                else if (step == 1) dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

}
