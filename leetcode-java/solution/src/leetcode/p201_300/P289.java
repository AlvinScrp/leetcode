package leetcode.p201_300;

public class P289 {

    public static void main(String[] args) {

    }

//    如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
//    如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
//    如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
//    如果死细胞周围正好有三个活细胞，则该位置死细胞复活；

    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int liveCount = 0;
                for (int[] direction : directions) {
                    liveCount += getLive(board, i + direction[0], j + direction[1]);
                }
                if (getLive(board, i, j) == 0) {
                    board[i][j] += 2 * (liveCount == 3 ? 1 : 0);
                } else {
                    board[i][j] += 2 * (liveCount == 2 || liveCount == 3 ? 1 : 0);

                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }

    }

    private static int[][] directions = new int[][]{
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static int getLive(int[][] board, int i, int j) {
        if ((i >= 0 && i < board.length) && (j >= 0 && j < board[i].length)) {
            return board[i][j] & 1;
        }
        return 0;
    }


}
