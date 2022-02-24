package leetcode_jianzhioffer;

public class J04 {

//
//            [
//            [1,   4,  7, 11, 15],

//            [2,   5,  8, 12, 19],

//            [3,   6,  9, 16, 22],

//            [10, 13, 14, 17, 24],

//            [18, 21, 23, 26, 30]
//            ]
//    给定 target = 5，返回 true。
//
//    给定 target = 20，返回 false。

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;

        int m = matrix.length, n = matrix[0].length;


        for (int i = 0, j = n - 1; i < m && j > 0; ) {
            if (target > matrix[i][j]) i++;
            else if (target < matrix[i][j]) j--;
            else return true;
        }
        return false;
    }


}
