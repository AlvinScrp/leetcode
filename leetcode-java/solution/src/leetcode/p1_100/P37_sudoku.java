package leetcode.p1_100;

public class P37_sudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        printBoard(board);
        System.out.println();
        solveSudoku(board);

        printBoard(board);
    }


    public static void solveSudoku(char[][] board) {
        dfs(board, 0, 9 * 9);
    }

    private static boolean dfs(char[][] board, int index, int n) {

        if (index == n) {
            return true;
        }
        int row = index / 9, col = index % 9;
        if (board[row][col] != '.') {
            boolean find = dfs(board, index + 1, n);
            if (find) {
                return true;
            }
        } else {
            for (char value = '1'; value <= '9'; value++) {
                if (isValid(board, row, col, value)) {
                    board[row][col] = value;
                    boolean find = dfs(board, index + 1, n);
                    if (find) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
        }
        return false;

    }

    public static boolean isValid(char[][] board, int row, int col, char value) {
        return isRowValid(board, row, col, value)
                && isColValid(board, row, col, value)
                && isBlockValid(board, row, col, value);
    }

    public static boolean isRowValid(char[][] board, int row, int col, char value) {

        for (char c : board[row]) {
            if (c == value) {
                return false;
            }

        }
        return true;
    }

    public static boolean isColValid(char[][] board, int row, int col, char value) {
        for (int i = 0; i < board.length; i++) {
            if (value == board[i][col]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBlockValid(char[][] board, int row, int col, char value) {
        int firstRow = row / 3 * 3;
        int firstCol = col / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[firstRow + i][firstCol + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }


    private static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
