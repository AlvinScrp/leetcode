class A1143 {

    public static void main(String[] args) {
        // System.out.println(new A1143().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();
            int[][] f = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        f[i][j] = f[i - 1][j - 1] + 1;
                    }
                    f[i][j] = Math.max(f[i][j], Math.max(f[i - 1][j], f[i][j - 1]));
                }
            }
            return f[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







