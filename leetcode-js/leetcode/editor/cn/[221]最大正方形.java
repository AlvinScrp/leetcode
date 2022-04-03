class A221 {

    public static void main(String[] args) {
        // System.out.println(new A221().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int max = 0;

            int[][] f = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        if (i == 0 || j == 0) {
                            f[i][j] = 1;
                        } else {
                            f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                        }
                        max = Math.max(max, f[i][j]);
                    }
                }
            }
            return max * max;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







