package leetcode_contest.weekly_289;

public class P6072 {
    public static void main(String[] args) {
        System.out.println(extract(20, 5));
        System.out.println(extract(20, 2));
        System.out.println(new P6072().maxTrailingZeros(new int[][]{{23, 17, 15, 3, 20}, {8, 1, 20, 27, 11}, {9, 4, 6, 2, 21}, {40, 9, 1, 10, 6}, {22, 7, 4, 5, 3}}));
    }

    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] nums = new int[m][n][2];
        int[][][] left = new int[m][n][2];
        int[][][] top = new int[m][n][2];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j][0] = extract(grid[i][j], 2);
                nums[i][j][1] = extract(grid[i][j], 5);
                top[i][j][0] = nums[i][j][0] + (i > 0 ? top[i - 1][j][0] : 0);
                top[i][j][1] = nums[i][j][1] + (i > 0 ? top[i - 1][j][1] : 0);
                left[i][j][0] = nums[i][j][0] + (j > 0 ? left[i][j - 1][0] : 0);
                left[i][j][1] = nums[i][j][1] + (j > 0 ? left[i][j - 1][1] : 0);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] cur = nums[i][j];
                int[] l = j > 0 ? left[i][j - 1] : new int[]{0, 0};
                int[] r = new int[]{left[i][n - 1][0] - left[i][j][0], left[i][n - 1][1] - left[i][j][1]};
                int[] t = i > 0 ? top[i - 1][j] : new int[]{0, 0};
                int[] b = new int[]{top[m - 1][j][0] - top[i][j][0], top[m - 1][j][1] - top[i][j][1]};

                ans = Math.max(ans, Math.min(l[0] + cur[0] + t[0], l[1] + cur[1] + t[1]));
                ans = Math.max(ans, Math.min(l[0] + cur[0] + b[0], l[1] + cur[1] + b[1]));
                ans = Math.max(ans, Math.min(r[0] + cur[0] + t[0], r[1] + cur[1] + t[1]));
                ans = Math.max(ans, Math.min(r[0] + cur[0] + b[0], r[1] + cur[1] + b[1]));
            }
        }

        return ans;
    }

    private static int extract(int a, int b) {
        int count = 0;
        while (a % b == 0) {
            count++;
            a = a / b;
        }
        return count;

    }
}
