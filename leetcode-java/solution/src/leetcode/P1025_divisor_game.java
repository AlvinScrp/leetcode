package leetcode;

public class P1025_divisor_game {
    public static void main(String[] args) {
        System.out.println(divisorGame(9));
        System.out.println(divisorGame(10));
    }

    public static boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i < N + 1; i++) {
            dp[i] = false;
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];

    }
}

