package leetcode.dp;

import java.util.Arrays;

public class P329 {

    /**
     * 输入: nums =
     * [
     * [9,9,4],
     * [6,6,8],
     * [2,1,1]
     * ]
     * 输出: 4
     * 解释: 最长递增路径为 [1, 2, 6, 9]。
     * 示例 2:
     * <p>
     * 输入: nums =
     * [
     * [3,4,5],
     * [3,2,6],
     * [2,2,1]
     * ]
     * 输出: 4
     * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
     *
     * @param matrix
     * @return
     */

    public static void main(String[] args) {
//        System.out.println(new P329().longestIncreasingPath(new int[][]{
//                {9, 9, 4},
//                {6, 6, 8},
//                {2, 1, 1}
//        }) + ",4");
//        System.out.println(new P329().longestIncreasingPath(new int[][]{
//                {3, 4, 5},
//                {3, 2, 6},
//                {2, 2, 1}
//        }) + ",4");

        System.out.println(new P329().longestIncreasingPath(new int[][]{
                {7, 8, 9},
                {9, 7, 6},
                {7, 2, 3}
        }) + ",6");


    }

    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    dfs(i, j, m, n, dp, matrix);
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int m, int n, int[][] dp, int[][] matrix) {

        if (dp[i][j] > 0) return dp[i][j];
        dp[i][j] = 1;
        for (int[] direction : directions) {
            int tempI = i + direction[0];
            int tempJ = j + direction[1];
            if (tempI >= 0 && tempI < m && tempJ >= 0 && tempJ < n
                    && (matrix[tempI][tempJ] > matrix[i][j])) {
                dp[i][j] = Math.max(dp[i][j], dfs(tempI, tempJ, m, n, dp, matrix) + 1);
            }
        }
        return dp[i][j];
    }
}
