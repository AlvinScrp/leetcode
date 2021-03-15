package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P935 {

    public static void main(String[] args) {
        System.out.println(knightDialer(1));
        System.out.println(knightDialer(2));
        System.out.println(knightDialer(3));
    }


    public static int knightDialer(int N) {

        int mod = 1000000007;
        int[][] froms = new int[][]{
                {4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9},
                {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};

        int[][] dp = new int[N + 1][10];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int from : froms[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][from]) % mod;
                }
            }
        }

        int ans = 0;
        for (int count : dp[N]) ans = (ans + count) % mod;
        return ans;

    }
}
