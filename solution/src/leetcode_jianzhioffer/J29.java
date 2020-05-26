package leetcode_jianzhioffer;


public class J29 {

//    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//             
//
//    示例 1：
//
//    输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//    输出：[1,2,3,6,9,8,7,4,5]
//    示例 2：
//
//    输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//    输出：[1,2,3,4,8,12,11,10,9,5,6,7]


//    public int[] spiralOrder(int[][] matrix) {
//        int m=matrix.length;
//        int n=matrix[0].length;
//
//        int[] res=new int[m*n];
//
//
//
//    }

    public static void main(String[] args) {
        new J29().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }


    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];


        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int l = 0, r = n - 1, t = 0, b = m - 1;
        int k = 0;
        while (true) {
            for (int j = l; j <= r; j++)
                res[k++] = matrix[t][j];

            if (++t > b) break;
            for (int i = t; i <= b; i++)
                res[k++] = matrix[i][r];

            if (l > --r) break;
            for (int j = r; j >= l; j--)
                res[k++] = matrix[b][j];

            if (t > --b) break;
            for (int i = b; i >= t; i--)
                res[k++] = matrix[i][l];

            if (++l > r) break;
        }
        return res;


    }
}
