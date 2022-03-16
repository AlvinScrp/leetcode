class A79 {

    public static void main(String[] args) {
        // System.out.println(new A79().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public boolean exist(char[][] board, String word) {
            int m = board.length, n = board[0].length;

            boolean[][] used = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, i, j, m, n, 0, word, used)) return true;
                }
            }
            return false;

        }

        private boolean dfs(char[][] board, int i, int j, int m, int n, int index, String word, boolean[][] used) {
            if (i < 0 || i >= m || j < 0 || j >= n || used[i][j] || board[i][j] != word.charAt(index)) return false;

            if (index == word.length() - 1) return true;
          
            used[i][j] = true;
            int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
            for (int[] d : directions) {
                if (dfs(board, i + d[0], j + d[1], m, n, index + 1, word, used)) {
                    return true;
                }
            }
            used[i][j] = false;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







