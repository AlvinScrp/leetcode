import java.util.LinkedList;

class A79 {

    public static void main(String[] args) {
        // System.out.println(new A79().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        String w;
        char[][] board;
        boolean[][] used;
        int m, n;

        public boolean exist(char[][] board, String word) {
            this.w = word;
            this.board = board;
            m = board.length;
            n = board[0].length;
            used = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(0, i, j))  return true;
                }
            }
            return false;
        }

        private boolean dfs(int start, int i, int j) {
            if (i < 0 || i >= m || j < 0 || j >= n || used[i][j] || w.charAt(start) != board[i][j]) return false;
            if (start == w.length() - 1) return true;
            used[i][j] = true;
//            path.addLast(new int[]{i, j});
            if (dfs(start + 1, i + 1, j)) return true;
            if (dfs(start + 1, i - 1, j)) return true;
            if (dfs(start + 1, i, j + 1)) return true;
            if (dfs(start + 1, i, j - 1)) return true;
//            path.removeLast();
            used[i][j] = false;
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







