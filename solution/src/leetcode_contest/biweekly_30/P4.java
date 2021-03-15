package leetcode_contest.biweekly_30;

import java.util.Set;

public class P4 {

    public static void main(String[] args) {

        long time = System.currentTimeMillis();
//        System.out.println(winnerSquareGame(8359));
        System.out.println(winnerSquareGame(2) + ",false");
        System.out.println(winnerSquareGame(4) + ",true");
        System.out.println(winnerSquareGame(7) + ",false");
        System.out.println(winnerSquareGame(17) + ",false");
        System.out.println(winnerSquareGame(8359) + ",false");
        System.out.println((System.currentTimeMillis() - time));

    }

    public static boolean winnerSquareGame(int n) {

        if (n == 0) return false;

        int length = (int) Math.sqrt(n);

        int[] choices = new int[length];
        for (int i = 0; i < length; i++) {
            choices[i] = (i + 1) * (i + 1);
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;

        for (int i = 2; i <= n; i++) {
            for (int choice : choices) {
                if (choice > i) break;
                if (!dp[i - choice]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];

    }
}
