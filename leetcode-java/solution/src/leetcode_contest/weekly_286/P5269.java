package leetcode_contest.weekly_286;

import java.util.List;

public class P5269 {

    public static void main(String[] args) {
        System.out.println();

    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] sum = new int[n][];
        for (int i = 0; i < n; i++) {
            sum[i] = new int[piles.get(i).size()];
            for (int j = 0; j < piles.get(i).size(); j++) {
                sum[i][j] = (j > 0 ? sum[i][j - 1] : 0) + piles.get(i).get(j);
            }
        }
        //分组背包
        int[][] f = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                f[i][j] = f[i - 1][j];
                for (int x = 1; x <= sum[i - 1].length && x <= j; x++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - x] + sum[i - 1][x - 1]);
                }
            }
        }
        return f[n][k];


    }


}
