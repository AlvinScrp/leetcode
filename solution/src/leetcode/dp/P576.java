package leetcode.dp;

public class P576 {

    public static void main(String[] args) {
        System.out.println(new P576().findPaths(2, 2, 2, 0, 0) + "," + "6");
        System.out.println(new P576().findPaths(1, 3, 3, 0, 1) + "," + "12");
    }

    public int findPaths(int m, int n, int N, int i, int j) {
        if (N == 0) return 0;
        if (m == 1 && n == 1) return 4;

        //f(k,x,y)定义当移动K次后，到i，j的路径数量
        int[][][] dp = new int[N + 1][m][n];
        dp[0][i][j] = 1;

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int count = 0;
        int MOD = 1000000007;

        for (int k = 1; k <= N; k++) {
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    int val = dp[k - 1][x][y];
                    if (val == 0) continue;
                    for (int[] direction : directions) {
                        int tempX = direction[0] + x;
                        int tempY = direction[1] + y;
                        if (tempX < 0 || tempX >= m) count = (count + val) % MOD;
                        else if (tempY < 0 || tempY >= n) count = (count + val) % MOD;
                        else {
                            dp[k][tempX][tempY] = (dp[k][tempX][tempY] + val) % MOD;
                        }
                    }
                }
            }
        }
        return count;

    }
}
