import java.util.List;

class A139 {

    public static void main(String[] args) {
        // System.out.println(new A139().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            boolean[] f = new boolean[n + 1];
            f[0] = true;
            for (int i = 1; i <= n; i++) {
                for (String word : wordDict) {
                    int j = i - word.length();
                    if (j >= 0) {
                        f[i] = s.substring(j, i).equals(word) && f[j];
                        if (f[i]) break;
                    }
                }
            }

            return f[n];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







