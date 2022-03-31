class A121 {

    public static void main(String[] args) {
        // System.out.println(new A121().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int gain = 0, cost = 10001;
            for (int price : prices) {
                gain = Math.max(gain, price - cost);
                cost = Math.min(cost, price);
            }
            return gain;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







