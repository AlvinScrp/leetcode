public class P63_UniquePathsWithObstacles {


    public static void main(String[] args) {

        int[][] obstacleGrid1 = new int[3][3];
        obstacleGrid1[1][1] = 1;
        System.out.println(uniquePathsWithObstacles(obstacleGrid1));

        int[][] obstacleGrid2 = new int[3][2];
        obstacleGrid2[1][0] = 1;
        obstacleGrid2[1][1] = 1;
        System.out.println(uniquePathsWithObstacles(obstacleGrid2));
    }


    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] f = new int[m][n];
        f[0][0] = 1 - obstacleGrid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                    continue;
                }
                f[i][j] = (i > 0 ? f[i - 1][j] : 0) + (j > 0 ? f[i][j - 1] : 0);
            }
        }
        return f[m - 1][n - 1];

    }

}
