package leetcode.p101_200;

public class P130 {

    public void solve(char[][] board) {

        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;
        int[][] flags = new int[m][n];

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, m, n, flags);
            dfs(board, i, n - 1, m, n, flags);
        }
        for (int j = 1; j < n - 1; j++) {
            dfs(board, 0, j, m, n, flags);
            dfs(board, m - 1, j, m, n, flags);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
               if(board[i][j] == 'O' && flags[i][j] == 0) board[i][j]='X';
            }
        }

    }

    int[][] directs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void dfs(char[][] board, int i, int j, int m, int n, int[][] flags) {
        if (i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 'O' && flags[i][j] == 0) {
            flags[i][j] = 1;
            for (int[] direct : directs) dfs(board, i + direct[0], j + direct[1], m, n, flags);
        }
    }
}
