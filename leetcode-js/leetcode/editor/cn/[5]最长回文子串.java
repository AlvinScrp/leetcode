class A5 {

    public static void main(String[] args) {
        System.out.println(new A5().new Solution().longestPalindrome("bb"));
        System.out.println(new A5().new Solution().longestPalindrome("bab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() <= 1) return s;
            int n = s.length();
            //dp[i][j] 表示i...j是否为回文
            boolean[][] dp = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }
            int maxL = 1, start = 0, j;
            for (int L = 2; L <= n; L++) {
                for (int i = 0; i + L - 1 < n; i++) {
                    j = i + L - 1;
                    if (L == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                    }
                    if (dp[i][j]) {
                        maxL = L;
                        start = i;
                    }
                }
            }
            return s.substring(start, start + maxL);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}