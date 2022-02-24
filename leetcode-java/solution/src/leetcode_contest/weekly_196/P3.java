package leetcode_contest.weekly_196;

public class P3 {

    public static void main(String[] args) {
        System.out.println(numSubmat(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}));

    }


    public static int numSubmat(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int maxX = m - 1, maxJ = n - 1;
                for (int x = i; x <= maxX; x++) {
                    int y = j;
                    if (mat[x][y] == 0) break;
                    for (; y <= maxJ && mat[x][y] == 1; y++) {
                        count++;
                    }
                    maxJ = y - 1;
                }
            }
        }
        return count;

    }


}
