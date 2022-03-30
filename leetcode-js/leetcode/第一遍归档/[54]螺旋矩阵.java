import java.util.ArrayList;
import java.util.List;

class A54 {

    public static void main(String[] args) {
        System.out.println(new A54().new Solution().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}).toString());
        System.out.println(new A54().new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}).toString());

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            int m = matrix.length, n = matrix[0].length;
            int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for (int i = 0, j = 0, d = 0, x, y; ans.size() < m * n; ) {
                ans.add(matrix[i][j]);
                matrix[i][j] = 101;
                x = i + directions[d][0];
                y = j + directions[d][1];
                boolean valid = 0 <= x && x < m && 0 <= y && y < n && matrix[x][y] != 101;
                if (!valid) d = (d + 1) % 4;
                i = i + directions[d][0];
                j = j + directions[d][1];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}