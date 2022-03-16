class A122 {

    public static void main(String[] args) {
        // System.out.println(new A122().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {

            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    sum += prices[i] - prices[i - 1];
                }
            }
            return sum;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







