class A48 {

    public static void main(String[] args) {
        // System.out.println(new A48().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {

            int t = 0, b = matrix.length - 1, l = 0, r = matrix[0].length - 1;
            int n = matrix.length - 1;

            while (t < b && l < r) {
                for (int k = l; k < r; k++) {
                    int temp = matrix[t][k];
                    matrix[t][k] = matrix[n - k][l];
                    matrix[n - k][l] = matrix[b][n - k];
                    matrix[b][n - k] = matrix[k][r];
                    matrix[k][r] = temp;
                }
                l++;
                r--;
                t++;
                b--;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







