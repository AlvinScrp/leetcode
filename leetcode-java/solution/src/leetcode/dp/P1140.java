package leetcode.dp;

import java.util.Arrays;

public class P1140 {

    public static void main(String[] args) {
        System.out.println(new P1140().stoneGameII(new int[]{2, 7, 9, 4, 4}));
    }

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        if (n == 0) return 0;
        if (n == 1) return piles[0];
        if (n == 2) return piles[0] + piles[1];

        int maxM = n;
        int[][] dp = new int[n][maxM + 1];

        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += piles[i];
            for (int m = maxM; m >= 1; m--) {
                if (i + m * 2 >= n) {
                    dp[i][m] = sum;
                } else {
                    for (int x = m * 2; x >= 1; x--) {
                        dp[i][m] = Math.max(dp[i][m], sum - dp[i + x][Math.max(x, m)]);
                    }
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[0][1];

    }
}
