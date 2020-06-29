package leetcode.p1_100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P36 {

    public static void main(String[] args) {
        new P36().isValidSudoku(new char[][]{{'.', '.', '.', '.', '5', '.', '.', '1', '.'}, {'.', '4', '.', '3', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '3', '.', '.', '1'}, {'8', '.', '.', '.', '.', '.', '.', '2', '.'}, {'.', '.', '2', '.', '7', '.', '.', '.', '.'}, {'.', '1', '5', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '2', '.', '.', '.'}, {'.', '2', '.', '9', '.', '.', '.', '.', '.'}, {'.', '.', '4', '.', '.', '.', '.', '.', '.'}});
    }

    public boolean isValidSudoku(char[][] board) {

//        for (char[] chars : board) {
//            System.out.println(chars);
//        }

//        Set<Character> nums = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));

        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] blocks = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int ch = board[i][j] - '0';
                if (ch >= 1 && ch <= 9) {
                    rows[i][ch]++;
                    if (rows[i][ch] > 1) return false;

                    cols[j][ch]++;
                    if (cols[j][ch] > 1) return false;

                    blocks[i / 3][j / 3][ch]++;
                    if (blocks[i / 3][j / 3][ch] > 1) return false;

                }
            }

        }
        return true;
    }
}
