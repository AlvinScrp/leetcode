class A5 {

    public static void main(String[] args) {
        // System.out.println(new A5().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            if (n == 1) return s;
            int[] dp = new int[]{0, -1};//{max,start}

            for (int i = 0; i < n; i++) {
                sub(i, i, s, dp);
                sub(i, i + 1, s, dp);
            }

            return s.substring(dp[1], dp[1] + dp[0]);

        }

        private void sub(int i, int j, String s, int[] dp) {
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }
            int L = j - i - 1;
            if (L > dp[0]) {
                dp[0] = L;
                dp[1] = i + 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







