package leetcode_contest.biweekly_28;

import java.util.Arrays;

public class P1 {

    public static void main(String[] args) {
        System.out.println();

    }

    public int[] finalPrices(int[] prices) {
        if (prices == null || prices.length == 0) return new int[0];
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    price = prices[i] - prices[j];
                    break;
                }
            }
            ans[i] = price;
        }
        return ans;

    }


}
