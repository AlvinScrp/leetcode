package leetcode.dp;

public class P877 {

    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{5,3,4,5}));
    }

    public static boolean stoneGame(int[] piles) {

        int n = piles.length;
        if (n <= 2) return true;

        int[][] dp = new int[n][n];

        for (int step = 0; step < n; step++) {
            for (int i = 0; i < n && i + step < n; i++) {
                int j = i + step;
                if (step == 0) dp[i][j] = -piles[i];
                else {
                    if (step % 2 == 1) {
                        dp[i][j] = Math.max(dp[i + 1][j] + piles[i], dp[i][j - 1] + piles[j]);
                    } else {
                        dp[i][j] = Math.min(dp[i + 1][j] - piles[i], dp[i][j - 1] - piles[j]);
                    }
                }
            }
        }
        return dp[0][n - 1] > 0;

    }


}
