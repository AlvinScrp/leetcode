import java.util.Arrays;

class A322 {

    public static void main(String[] args) {
        System.out.println(new A322().new Solution().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new A322().new Solution().coinChange(new int[]{2}, 3));
        System.out.println(new A322().new Solution().coinChange(new int[]{1}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i - coin >= 0) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
//public int coinChange(int[] coins, int amount) {
//    if (amount == 0) return 0;
//    int[] dp = new int[amount + 1];
//    Arrays.fill(dp, -1);
//    dp[0] = 0;
//    for (int i = 1; i <= amount; i++) {
//        for (int coin : coins) {
//            int j = i - coin;
//            if (j >= 0 && dp[j] >= 0) {
//                dp[i] = dp[i] < 0 ? (dp[j] + 1) : Math.min(dp[i], dp[j] + 1);
//            }
//        }
//    }
//    return dp[amount];
//
//}
}







