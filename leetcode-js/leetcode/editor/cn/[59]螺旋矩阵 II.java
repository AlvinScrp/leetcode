class A59 {

    public static void main(String[] args) {
        // System.out.println(new A59().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {

            int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int[][] ans = new int[n][n];
            int count = 1, size = n * n, d = 0;
            for (int i = 0, j = 0; count <= size; count++) {
                ans[i][j] = count;
                int x = i + direction[d][0];
                int y = j + direction[d][1];
                if (x < 0 || x >= n || y < 0 || y >= n || ans[x][y] > 0) {
                    d = (d + 1) % 4;
                    i = i + direction[d][0];
                    j = j + direction[d][1];
                } else {
                    i = x;
                    j = y;
                }
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}







