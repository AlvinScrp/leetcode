package leetcode.dp;

public class P44 {
    /**
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * <p>
     * 输入:
     * s = "aa"
     * p = "*"
     * 输出: true
     * 解释: '*' 可以匹配任意字符串。
     * <p>
     * 输入:
     * s = "cb"
     * p = "?a"
     * 输出: false
     * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
     * <p>
     * 输入:
     * s = "adceb"
     * p = "*a*b"
     * 输出: true
     * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
     * <p>
     * 输入:
     * s = "acdcb"
     * p = "a*c?b"
     * 输出: false
     */
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a") + ",false");
        System.out.println(isMatch("aa", "*") + ",true");
        System.out.println(isMatch("cb", "?a") + ",false");
        System.out.println(isMatch("adceb", "*a*b") + ",true");
        System.out.println(isMatch("acdcb", "a*c?b") + ",false");
        System.out.println(isMatch("aab", "c*a*b") + ",false");
        System.out.println(isMatch("a", "a*") + ",true");
        System.out.println(isMatch("ho", "**ho") + ",true");
//        System.out.println(isMatch("a", "a") + ",true");
    }

    /**
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     *
     * @param s
     * @param p
     * @return
     */
//    public static boolean isMatch(String s, String p) {
//        int[][] dp = new int[s.length()][p.length()];
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < p.length(); j++) {
//                dp[i][j] = -1;
//            }
//        }
//        return isMatch(s, p, s.length() - 1, p.length() - 1, dp);
//    }
//
//    public static boolean isMatch(String s, String p, int i, int j, int[][] dp) {
//        if (j < 0) return i < 0;
//        if (i < 0) return p.charAt(j) == '*' && isMatch(s, p, i, j - 1, dp);
//
//        if (dp[i][j] == -1) {
//            boolean match = false;
//            if (p.charAt(j) == '*') {
//                match = isMatch(s, p, i - 1, j - 1, dp) || isMatch(s, p, i - 1, j, dp) || isMatch(s, p, i, j - 1, dp);
//            } else if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
//                match = isMatch(s, p, i - 1, j - 1, dp);
//            }
//            dp[i][j] = match ? 1 : 0;
//        }
//        return dp[i][j] == 1;
//    }
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = p.charAt(j - 1) == '*' && dp[i][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1];
                } else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }


}
