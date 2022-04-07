class A695 {

    public static void main(String[] args) {
        // System.out.println(new A695().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int count = dfs(grid, i, j, m, n);
                        ans = Math.max(ans, count);
                    }
                }
            }
            return ans;
        }

        private int dfs(int[][] grid, int i, int j, int m, int n) {
            if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return 0;
            int count = 1;
            grid[i][j] = 2;
            count += dfs(grid, i, j + 1, m, n);
            count += dfs(grid, i, j - 1, m, n);
            count += dfs(grid, i + 1, j, m, n);
            count += dfs(grid, i - 1, j, m, n);
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







