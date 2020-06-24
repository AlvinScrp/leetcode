package leetcode.dp;

import java.util.Arrays;

public class P322_CoinChange {


    public static void main(String[] args) {


        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        int[] coins2 = {2};
        int amount2 = 3;
        int[] coins3 = {2, 5, 7};
        int amount3 = 27;
        System.out.println("最少的硬币个数:" + coinChange(coins1, amount1));
        System.out.println("最少的硬币个数:" + coinChange(coins2, amount2));
        System.out.println("最少的硬币个数:" + coinChange(coins3, amount3));
    }

    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     * <p>
     * 示例 1:
     * 输入: coins = [1, 2, 5], amount = 11
     * 输出: 3
     * 解释: 11 = 5 + 5 + 1
     * 示例 2:
     * <p>
     * 输入: coins = [2], amount = 3
     * 输出: -1
     * 说明:
     * 你可以认为每种硬币的数量是无限的。
     */
    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] >= 0) {
                    int count = dp[i - coin] + 1;
                    dp[i] = dp[i] < 0 ? count : Math.min(dp[i], count);
                }
            }
        }
        return dp[amount];
    }


}
