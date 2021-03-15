package leetcode.p101_200;

public class P121_best_time_to_buy_and_sell_stock {


    public static void main(String[] args) {


        int[] coins1 = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit1(coins1));
        System.out.println(maxProfit(coins1));
    }

    //
//    public static int maxProfit(int[] prices) {
//        int n = prices.length;
//        if (n == 0 || n == 1) {
//            return 0;
//        }
//        int[] fMins = new int[n];
//        fMins[0] = prices[0];
//        for (int i = 1; i < n; i++) {
//            fMins[i] = Math.min(fMins[i - 1], prices[i]);
//        }
//        int maxProfit = 0;
//        for (int i = 1; i < n; i++) {
//            maxProfit = Math.max(maxProfit, prices[i] - fMins[i - 1]);
//        }
//        return maxProfit;
//
//    }
    public static int maxProfit1(int[] prices) {


        int last = 0, profit = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            last = Math.max(0, last + prices[i + 1] - prices[i]);
            profit = Math.max(profit, last);
        }
        return profit;
    }

    //7, 1, 5, 3, 6, 4
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        //第i天时，最大收益。 尚未操作/第一次买入/第一次卖出
        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i][2]);
        }
        return max;
    }


}
