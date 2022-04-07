class A518 {

    public static void main(String[] args) {
        // System.out.println(new A518().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int change(int amount, int[] coins) {

            int[] f = new int[amount + 1];
            f[0] = 1;
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    f[i] += f[i - coin];
                }
            }
            return f[amount];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







