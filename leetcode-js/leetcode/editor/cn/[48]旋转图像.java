class A48 {

    public static void main(String[] args) {
        // System.out.println(new A48().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    swap(matrix, i, j, j, i);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int p = 0, q = n - 1; p < q; p++, q--) {
                    swap(matrix, i, p, i, q);
                }
            }

        }

        private void swap(int[][] matrix, int i, int j, int p, int q) {
            int t = matrix[i][j];
            matrix[i][j] = matrix[p][q];
            matrix[p][q] = t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







