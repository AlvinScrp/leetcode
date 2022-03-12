class A32 {

    public static void main(String[] args) {
        System.out.println(new A32().new Solution().longestValidParentheses(")()())"));
        System.out.println(new A32().new Solution().longestValidParentheses(""));
        System.out.println(new A32().new Solution().longestValidParentheses("()"));
        System.out.println(new A32().new Solution().longestValidParentheses("()(())"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int n = s.length();
            if (n <= 1) return 0;
            int ans = 0;
            char[] chars = s.toCharArray();
            int dp[] = new int[n];
            for (int i = 1; i < n; i++) {
                if (chars[i] == ')') {
                    if (chars[i - 1] == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else {
                        if (dp[i - 1] > 0) {
                            int j = i - dp[i - 1] - 1;
                            if (j >= 0 && chars[j] == '(') {
                                dp[i] = dp[i - 1] + 2 + (j > 1 ? dp[j - 1] : 0);
                            }
                        }
                    }
                }
                ans = Math.max(ans, dp[i]);
            }

            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







