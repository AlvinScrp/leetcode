package leetcode.p101_200;

public class P200 {

    public static void main(String[] args) {
        System.out.println(new P200().numIslands(new char[][]{
                {'1','1','1','1','0',},
                {'1','1','0','1','0',},
                {'1','1','0','0','0',},
                {'0','0','0','0','0',},
        }));

        System.out.println(new P200().numIslands(new char[][]{
                {'1','1','0','0','0',},
                {'1','1','0','0','0',},
                {'0','0','1','0','0',},
                {'0','0','0','1','1',},
        }));
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m==0) return 0;

        int n = grid[0].length;
        if(n==0) return 0;

        int[][] flags = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && flags[i][j] == 0) {
                    count++;
                    flags[i][j] = 1;
                    dfs(grid, i, j, m, n, flags);
                }
            }
        }
        return count;

    }

    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(char[][] grid, int i, int j, int m, int n, int[][] flags) {

        for (int[] direct : directions) {
            int x = i + direct[0], y = j + direct[1];
            if (x >= 0 && x < m && y >= 0 && y < n && flags[x][y] == 0 && grid[x][y] == '1') {
                flags[x][y] = 1;
                dfs(grid, x, y, m, n, flags);
            }
        }
    }
}
