package leetcode.dp;

import java.util.Arrays;

public class P518 {
    public static void main(String[] args) {
        System.out.println(new P518().change(14, new int[]{1, 2, 5}));
    }


    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) return amount == 0 ? 1 : 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i < dp.length; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }


}
