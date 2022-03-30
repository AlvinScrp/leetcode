import java.util.HashSet;
import java.util.List;
import java.util.Set;

class A139 {

    public static void main(String[] args) {
        // System.out.println(new A139().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {

            Set<String> words = new HashSet<>(wordDict);

            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && words.contains(s.substring(j, i))) {
                        dp[i] = true;
                    }
                }
            }
            return dp[n];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







