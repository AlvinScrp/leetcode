package leetcode;

public class P62_UniquePaths {


    public static void main(String[] args) {


        System.out.println("uniquePaths(3,2):" + uniquePaths(3, 2));
        System.out.println("uniquePaths(7,3):" + uniquePaths(7, 3));
        System.out.println("uniquePaths(3,4):" + uniquePaths(3, 4));
    }

    public static int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        f[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                f[i][j] = (i == 0 ? 0 : f[i - 1][j]) + (j == 0 ? 0 : f[i][j - 1]);
            }
        }
        return f[m - 1][n - 1];

    }

}
