package leetcode;

public class P121_best_time_to_buy_and_sell_stock {


    public static void main(String[] args) {


        int[] coins1 = {7, 1, 5, 3, 6,4};

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
    public static int maxProfit(int[] prices) {


        int last = 0, profit = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            last = Math.max(0, last + prices[i+1] - prices[i]);
            profit = Math.max(profit, last);
        }
        return profit;



    }

}
