class A_Offer_62 {

    public static void main(String[] args) {
        // System.out.println(new A剑指 Offer 62().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastRemaining(int n, int m) {

            int ans = 0;
            for (int i = 2; i <= n; i++) {
                ans = (ans + m) % i;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







