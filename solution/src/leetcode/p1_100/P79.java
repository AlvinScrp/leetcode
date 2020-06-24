package leetcode.p1_100;

public class P79 {


//    int m, n;
//    int[][] f;
//
//    public boolean exist(char[][] board, String word) {
//        if (board == null || board.length == 0 || board[0].length == 0) return false;
//        if (word == null || word.length() == 0) return true;
//        m = board.length;
//        n = board[0].length;
//        f = new int[m][n];
//
//        char ch0 = word.charAt(0);
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (ch0 == board[i][j] && dfs(board, word, i, j, 0)) return true;
//            }
//        }
//        return false;
//
//    }
//
//    private boolean dfs(char[][] board, String word, int i, int j, int x) {
//        if (x == word.length()) return true;
//        if (0 <= i && i < m && 0 <= j && j < n
//                && word.charAt(x) == board[i][j]
//                && f[i][j] == 0) {
//            f[i][j] = 1;
//
//            boolean b = dfs(board, word, i - 1, j, x + 1) || dfs(board, word, i + 1, j, x + 1)
//                    || dfs(board, word, i, j - 1, x + 1) || dfs(board, word, i, j + 1, x + 1);
//            if (b) return b;
//            f[i][j] = 0;
//        }
//        return false;
//    }


}
