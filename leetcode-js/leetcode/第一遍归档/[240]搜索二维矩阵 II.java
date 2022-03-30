class A240 {

    public static void main(String[] args) {
        // System.out.println(new A240().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {

            int m = matrix.length;
            int n = matrix[0].length;
            for (int i = 0, j = n - 1; i < m && j >= 0; ) {
                int value = matrix[i][j];
                if (value == target) return true;
                if (target > value) i++;
                else j--;
            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







