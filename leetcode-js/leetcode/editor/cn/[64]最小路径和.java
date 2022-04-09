class A64 {

    public static void main(String[] args) {
        // System.out.println(new A64().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] f = new int[m][n];
            int Max = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) f[i][j] = grid[i][j];
                    else f[i][j] = Math.min(
                            i == 0 ? Max : f[i - 1][j],
                            j == 0 ? Max : f[i][j - 1]) + grid[i][j];
                }
            }
            return f[m - 1][n - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







