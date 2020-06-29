package leetcode.p1_100;

public class P48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int start = 0, end = n - 1; start < end; start++, end--)
            rotate(matrix, start, end);
    }

    private void rotate(int[][] a, int start, int end) {
        int t = start, b = end, l = start, r = end;

        int count = r - l;
        for (int k = 0; k < count; k++) {
            int temp = a[t][l + k];
            a[t][l + k] = a[b - k][l];
            a[b - k][l] = a[b][r - k];
            a[b][r - k] = a[t + k][r];
            a[t + k][r] = temp;
        }


    }
}
