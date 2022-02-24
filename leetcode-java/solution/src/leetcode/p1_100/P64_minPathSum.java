package leetcode.p1_100;

public class P64_minPathSum {

    public static void main(String[] args) {

        int[][] grid1 =new int[][] {{1,3,1},{1,5,1},{4,2,1}};



        System.out.println(minPathSum(grid1));

//        int[][] obstacleGrid2 = new int[3][2];
//        obstacleGrid2[1][0] = 1;
//        obstacleGrid2[1][1] = 1;
//        System.out.println(minPathSum(obstacleGrid2));
    }


    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            f[0][j] = f[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = grid[i][j] + Math.min(f[i - 1][j], f[i][j - 1]);
            }
        }
        return f[m - 1][n - 1];

    }
}