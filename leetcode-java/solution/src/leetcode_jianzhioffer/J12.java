package leetcode_jianzhioffer;

public class J12 {
    int[][] diractions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int m, n;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        if (word == null || word.length() == 0) return true;
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }

        return false;

    }

    private boolean dfs(char[][] board, String word, int i, int j, int x) {
        if (x == word.length()) return true;
        if (0 <= i && i < m && 0 <= j && j < n
                && word.charAt(x) == board[i][j]) {
            char temp = board[i][j];
            board[i][j] = '/';
            for (int[] d : diractions) {
                if (dfs(board, word, i + d[0], j + d[1], x + 1)) return true;
            }
            board[i][j] = temp;

        }
        return false;
    }
}
