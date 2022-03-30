class A695 {

    public static void main(String[] args) {
        // System.out.println(new A695().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0;

        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans = Math.max(ans, dfs(grid, i, j, m, n));
                }
            }
            return ans;

        }

        private int dfs(int[][] grid, int i, int j, int m, int n) {
            if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
                return 0;
            }
            int value = 1;
            grid[i][j] = -1;

            value += dfs(grid, i, j - 1, m, n);
            value += dfs(grid, i, j + 1, m, n);
            value += dfs(grid, i - 1, j, m, n);
            value += dfs(grid, i + 1, j, m, n);
            return value;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







