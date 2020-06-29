package leetcode.p1_100;

import java.util.Set;
import java.util.TreeSet;

public class P73 {

    public static void main(String[] args) {
        setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
    }

    public static void setZeroes(int[][] matrix) {
        TreeSet<Integer> rows = new TreeSet<>();
        TreeSet<Integer> cols = new TreeSet<>();

        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
//        System.out.println(rows);
//        System.out.println(cols);

        for (Integer row : rows) {
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
        }
        for (Integer col : cols) {
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
