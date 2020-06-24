package leetcode.divide_and_conquer;

public class P240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;

        for (int j = n - 1, i = 0; i < m && j >= 0; ) {

            int val = matrix[i][j];
            if (target == val) return true;
            else if (target < val) j--;
            else i++;
        }
        return false;
    }
}
