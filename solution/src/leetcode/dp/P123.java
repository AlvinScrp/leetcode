package leetcode.dp;

public class P123 {
    public static void main(String[] args) {
        System.out.println(new P123().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(new P123().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new P123().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        //第i天，5种状态下，拥有的最大利润，
        int[][] dp = new int[n][5];
        dp[0][0] = 0;//无股票。从未交易过
        dp[0][1] = -prices[0];//有股票，第一次买入
        dp[0][2] = 0;//无股票，第一次卖出
        dp[0][3] = -prices[0];//有股票，第二次买入
        dp[0][4] = 0;///无股票，第二次卖出

        for (int i = 1; i < n; i++) {
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        int ans = Math.max(0, Math.max(dp[n - 1][2], dp[n - 1][4]));
        return ans;
    }
}
