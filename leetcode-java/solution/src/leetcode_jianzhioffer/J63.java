package leetcode_jianzhioffer;

public class J63 {

    /**
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int ans = 0, min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            ans = Math.max(ans, price - min);
        }
        return ans;

    }
}
