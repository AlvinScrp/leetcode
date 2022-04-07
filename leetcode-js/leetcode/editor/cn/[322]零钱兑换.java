import java.util.Arrays;

class A322 {

    public static void main(String[] args) {
        // System.out.println(new A322().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int f[] = new int[amount + 1];
            Arrays.fill(f, amount + 1);
            f[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i - coin >= 0) {
                        f[i] = Math.min(f[i], f[i - coin] + 1);
                    }
                }
            }
            return f[amount] <= amount ? f[amount] : -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







