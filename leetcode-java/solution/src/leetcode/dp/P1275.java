package leetcode.dp;

import java.util.Arrays;

public class P1275 {

    public String tictactoe(int[][] moves) {

        int[][] dp = new int[3][3];

        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0], y = moves[i][1];
            int val = i % 2 == 0 ? 1 : 4;
            dp[x][y] = val;
            int sum = 3 * val;
            if ((dp[x][0] + dp[x][1] + dp[x][2]) == sum
                    || (dp[0][y] + dp[1][y] + dp[2][y]) == sum
                    || (dp[0][0] + dp[1][1] + dp[2][2]) == sum
                    || (dp[0][2] + dp[1][1] + dp[2][0]) == sum) {
                return i % 2 == 0 ? "A" : "B";
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
