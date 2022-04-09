class A72 {

    public static void main(String[] args) {
        // System.out.println(new A72().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int[][] f = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 && j == 0) f[i][j] = 0;
                    else if (i == 0) f[i][j] = j;
                    else if (j == 0) f[i][j] = i;
                    else {
                        boolean equal = word1.charAt(i - 1) == word2.charAt(j - 1);
                        f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
                        f[i][j] = Math.min(f[i - 1][j - 1] + (equal ? 0 : 1), f[i][j]);
                    }
                }
            }
            return f[m][n];


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







