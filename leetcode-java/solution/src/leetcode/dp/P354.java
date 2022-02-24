package leetcode.dp;

import java.util.Arrays;

public class P354 {
    public static void main(String[] args) {
        System.out.println(new P354().maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, ((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]));
        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}
