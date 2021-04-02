package leetcode.p501_600;

import java.util.Arrays;

public class P566 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P566().matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int[][] res = new int[r][c];
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) return nums;

        int size = m * n;
        for (int i = 0; i < size; i++) {
            res[i / c][i % c] = nums[i / n][i % n];
        }

        return res;
    }
}
