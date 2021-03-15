package leetcode.dp;

import java.util.Arrays;

public class P309 {

//    public static void main(String[] args) {
//        System.out.println(new P309().maxProfit(new int[]{1, 2, 3, 0, 2}));
//    }
//
//    public int maxProfit(int[] prices) {
//
//        int n = prices.length;
//        if (n < 2) return 0;
//
//        int[][] dp = new int[n + 1][3];
//        dp[0][0] = 0;//无股票，非冷冻期 a
//        dp[0][1] = -prices[0];//有股票 b
//        dp[0][2] = Integer.MIN_VALUE;//无股票，冷冻期 c
//        dp[1][2] = Integer.MIN_VALUE;//无股票，冷冻期 c
//
//        for (int i = 1; i < n; i++) {
//            if (dp[i][2] >= 0) {
//                dp[i][0] = dp[i][1] = Integer.MIN_VALUE;
//                continue;
//            }
//
//            int a = dp[i - 1][0], b = dp[i - 1][1], c = dp[i - 1][2];
//            int temp = Math.max(a, c);
//            if (b + prices[i] > temp) {
//                dp[i][0] = b + prices[i];
//                dp[i + 1][2] = dp[i][0];
//            } else {
//                dp[i][0] = temp;
//                dp[i + 1][2] = Integer.MIN_VALUE;
//            }
//            dp[i][1] = Math.max(b, a - prices[i]);
//
//
//        }
//
//        int ans = 0;
//        for (int i = 0; i < dp.length - 1; i++) {
//            ans = Math.max(ans, Math.max(dp[i][0], dp[i][2]));
//        }
//        return ans;
//
//    }

    public static void main(String[] args) {
        System.out.println(new P309().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }


    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        int a = 0;//无股票，非当天卖出 a
        int b = Integer.MIN_VALUE;//无股票，当天卖出 b ,min_value 表示不可抵达
        int c = Integer.MIN_VALUE;//无股票，冷冻期 c
        int d = -prices[0];//有股票 d
        int ans=0;

        for (int i = 1; i < n; i++) {
            int tempA = a, tempB = b, tempC = c, tempD = d;
            a = Math.max(tempA, tempC);
            b = tempD + prices[i];
            c = tempB;
            d = Math.max(Math.max(tempA, tempC) - prices[i], tempD);
            ans = Math.max(Math.max(ans,a), Math.max(b,c));
        }
        return ans;
    }
}
