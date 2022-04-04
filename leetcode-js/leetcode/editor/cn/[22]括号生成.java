import java.util.LinkedList;
import java.util.List;

class A22 {

    public static void main(String[] args) {
        // System.out.println(new A22().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        public List<String> generateParenthesis(int n) {
            dfs(n, n);
            return ans;

        }

        private void dfs(int m, int n) {
            if (m == 0 && n == 0) {
                ans.add(sb.toString());
                return;
            }
            if (m > 0) {
                sb.append('(');
                dfs(m - 1, n);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (n > m) {
                sb.append(')');
                dfs(m, n - 1);
                sb.deleteCharAt(sb.length() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







