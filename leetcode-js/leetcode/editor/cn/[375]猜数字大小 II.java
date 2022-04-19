class A375 {

    public static void main(String[] args) {
        // System.out.println(new A375().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int getMoneyAmount(int n) {
            int[][] cache = new int[n + 1][n + 1];
            return dfs(1, n, cache);
        }

        private int dfs(int l, int r, int[][] cache) {
            if (l >= r) return 0;
            if (cache[l][r] > 0) return cache[l][r];
            int ans = Integer.MAX_VALUE;
            for (int x = l; x <= r; x++) {
                int cur = Math.max(dfs(l, x - 1, cache), dfs(x + 1, r, cache)) + x;
                ans = Math.min(cur, ans);
            }
            cache[l][r] = ans;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







