class A121 {

    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) return 0;
            int max = 0;
            int cost = prices[0];
            for (int i = 1; i < prices.length; i++) {
                max = Math.max(max, prices[i] - cost);
                cost = Math.min(cost, prices[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}