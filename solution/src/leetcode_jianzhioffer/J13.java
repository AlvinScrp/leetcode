package leetcode_jianzhioffer;

import java.util.HashSet;
import java.util.Set;

public class J13 {

    public static void main(String[] args) {
        System.out.println(new J13().movingCount(11,8,16));
    }

    Set<Integer> set;

    public int movingCount(int m, int n, int k) {
        int[][] f = new int[m][n];
        set = new HashSet<>();
        dfs(0, 0, 0, m, n, k, f);
        return set.size();
    }

    private void dfs(int i, int j, int count, int m, int n, int k, int[][] f) {
        if (i >= 0 && i < m && j >= 0 && j < n
                && (i / 10 + i % 10 + j / 10 + j % 10) <= k
                && f[i][j] == 0) {
            count++;
            f[i][j] = 1;
            set.add(i*100+j);
            dfs(i - 1, j, count, m, n, k, f);
            dfs(i + 1, j, count, m, n, k, f);
            dfs(i, j - 1, count, m, n, k, f);
            dfs(i, j + 1, count, m, n, k, f);
//            f[i][j] = 0;
        }
    }
}
