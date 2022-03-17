class A1143 {

    public static void main(String[] args) {
        System.out.println(new A1143().new Solution().longestCommonSubsequence("abcde", "ace"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i < m + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    if (i == 0 || j == 0) dp[i][j] = 0;
                    else {
                        dp[i][j] = dp[i - 1][j - 1] + (text1.charAt(i - 1) == text2.charAt(j - 1) ? 1 : 0);
                        dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
                    }
                }
            }
            return dp[m][n];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







