package leetcode.dp;

import java.util.Arrays;

public class P794 {

    public static void main(String[] args) {
        System.out.println(new P794().validTicTacToe(new String[]{"XXX", "OOX", "OOX"}) + "," + true);
        System.out.println(new P794().validTicTacToe(new String[]{"XXX", "XOO", "OO "}) + "," + false);
    }


    public boolean validTicTacToe(String[] board) {
        int countA = 0, countB = 0;
        char[] dp = new char[9];
        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                countA += (ch == 'X' ? 1 : 0);
                countB += (ch == 'O' ? 1 : 0);
                dp[i * 3 + j] = ch;
            }
        }

        if (countA + countB == 0) return true;
        if (countA != countB && countA != countB + 1) return false;

        char last = countA == countB ? 'O' : 'X';
        for (int i = 0; i < 9; i++) {
            if (dp[i] != last) continue;
            dp[i] = 0;
            if (isValid(dp)) return true;
            dp[i] = last;
        }
        return false;


    }

    public static boolean isValid(char[] dp) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            count += isMatch(dp[i * 3], dp[i * 3 + 1], dp[i * 3 + 2]) ? 1 : 0;
        }
        if (count > 0) return false;
        for (int j = 0; j < 3; j++) {
            count += isMatch(dp[j], dp[3 + j], dp[6 + j]) ? 1 : 0;
        }
        if (count > 0) return false;
        count += isMatch(dp[0], dp[4], dp[8]) ? 1 : 0;
        count += isMatch(dp[2], dp[4], dp[6]) ? 1 : 0;
        return count == 0;

    }

    public static boolean isMatch(char a, char b, char c) {
        return a == b && b == c && (c == 'X' || c == 'O');

    }
}
