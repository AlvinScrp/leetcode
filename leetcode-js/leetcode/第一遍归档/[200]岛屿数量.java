class A200 {

    public static void main(String[] args) {
        System.out.println(new A200().new Solution().numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {


        public int numIslands(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        dfs(grid, m, n, i, j);
                    }
                }
            }
            return count;

        }

        private void dfs(char[][] grid, int m, int n, int i, int j) {

            if (0 <= i && i < m && 0 <= j && j < n && grid[i][j] == '1') {
                grid[i][j] = '2';
                dfs(grid, m, n, i + 1, j);
                dfs(grid, m, n, i - 1, j);
                dfs(grid, m, n, i, j + 1);
                dfs(grid, m, n, i, j - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}