import java.util.LinkedList;
import java.util.List;

class A54 {

    public static void main(String[] args) {
        // System.out.println(new A54().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new LinkedList<>();
            int m = matrix.length, n = matrix[0].length;
            int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for (int i = 0, j = 0, d = 0, x, y, size = m * n; ans.size() < size; ) {
                ans.add(matrix[i][j]);
                matrix[i][j] = 101;
                x = i + direction[d][0];
                y = j + direction[d][1];
                if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] > 100) {
                    d = (d + 1) % 4;
                }
                i = i + direction[d][0];
                j = j + direction[d][1];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







