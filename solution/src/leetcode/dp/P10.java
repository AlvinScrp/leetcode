package leetcode.dp;

public class P10 {

    public static void main(String[] args) {
        System.out.println(isMatch("mississippi", "mis*is*ip*."));
        System.out.println(isMatch("aa", "a"));
//        System.out.println(isCharMatch("miss", "mis*"));
//        System.out.println(isCharMatch( "aa", "a*"));
    }

//    public static boolean isMatch2(String s, String p) {
//
//        int m = s.length(), n = p.length();
//        boolean[][] dp = new boolean[m + 1][n + 1];
//        dp[0][0] = true;
//
//        for (int i = 0; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (p.charAt(j - 1) == '*') {
//                    dp[i][j] = dp[i][j - 2];
//                    if (dp[i][j]) continue;
//                    if (isCharMatch2(s, p, i, j - 1)) {
//                        dp[i][j] = dp[i - 1][j];
//                    }
//                } else {
//                    if (isCharMatch2(s, p, i, j)) {
//                        dp[i][j] = dp[i - 1][j - 1];
//                    }
//                }
//            }
//        }
//        for (boolean[] ints : dp) {
//            for (boolean anInt : ints) {
//                System.out.print((anInt ? 1 : 0) + ", ");
//            }
//            System.out.println();
//        }
//        return dp[m][n];
//    }
//
//    public static boolean isCharMatch2(String s, String p, int i, int j) {
//        if (i == 0) return false;
//        return p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1);
//    }

    public static boolean isMatch(String s, String p) {
        return isMatch(s, p, s.length() - 1, p.length() - 1);
    }

    public static boolean isMatch(String s, String p, int i, int j) {
        if (j < 0) return i < 0;
        if (p.charAt(j) == '*') {
            return isMatch(s, p, i, j - 2) || (isCharMatch(s, p, i, j - 1) && isMatch(s, p, i - 1, j));
        } else {
            return isCharMatch(s, p, i, j) && isMatch(s, p, i - 1, j - 1);
        }
    }

    public static boolean isCharMatch(String s, String p, int i, int j) {
        if (i < 0 || j < 0) return false;
        return p.charAt(j) == '.' || p.charAt(j) == s.charAt(i);
    }


}
