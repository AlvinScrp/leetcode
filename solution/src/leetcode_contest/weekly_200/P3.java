package leetcode_contest.weekly_200;

public class P3 {

    public static void main(String[] args) {

        System.out.println(new P3().minSwaps(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 1}}));
    }


    public int minSwaps(int[][] grid) {

        int n = grid.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int stepCount = fill(grid, i, n);
            if (stepCount < 0) return -1;
            count += stepCount;
        }
        return count;


    }

    private int fill(int[][] grid, int k, int n) {
        int row = -1;
        for (int i = k; i < n; i++) {
            row = i;
            for (int j = k + 1; j < n; j++) {
                if (grid[i][j] != 0) {
                    row = -1;
                    break;
                }
            }
            if (row >= 0) break;
        }

        if (row >= 0) {
            if (row == k) return 0;
            int[] temp = grid[row];
            for (int i = row; i > k; i--) {
                grid[i] = grid[i - 1];
            }
            grid[k] = temp;
            return row - k;
        }
        return -1;
    }


}
