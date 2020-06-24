package leetcode.binary_search;

public class P74 {

    /**
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     *
     * @param matrix
     * @param target
     * @return
     */
//    public boolean searchMatrix(int[][] matrix, int target) {
//
//        int m = matrix.length, n = matrix[0].length;
//
//        int lo = 0, hi = m - 1, mid, i = -1, j = -1;
//
//        while (lo <= hi) {
//            mid = (hi - lo) / 2 + lo;
//            if (target < matrix[mid][0]) hi = mid - 1;
//            else if (target > matrix[mid][n - 1]) lo = mid + 1;
//            else {
//                i = mid;
//                break;
//            }
//        }
//        if (i < 0) return false;
//
//        lo = 0;
//        hi = n - 1;
//        while (lo <= hi) {
//            mid = (hi - lo) / 2 + lo;
//            if (target < matrix[i][lo]) hi = mid - 1;
//            else if (target > matrix[i][hi]) lo = mid + 1;
//            else {
//                j = mid;
//                break;
//            }
//        }
//        return j >= 0;
//
//    }
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length, n = matrix[0].length;
        int length = m * n;
        int lo = 0, hi = length - 1, mid, midVal, index = -1;

        while (lo <= hi) {
            mid = (hi - lo) / 2 + lo;
            midVal = matrix[mid / n][mid % n];
            if (target < midVal) hi = mid - 1;
            else if (target > midVal) lo = mid + 1;
            else {
                index = mid;
                break;
            }
        }
        return index >= 0;
    }
}
