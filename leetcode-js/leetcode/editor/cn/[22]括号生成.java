import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class A22 {

    public static void main(String[] args) {
//        System.out.println(.toString());
        List<String> ans = new A22().new Solution().generateParenthesis(3);
        for (String an : ans) {
            System.out.print(an + ",");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            char[] path = new char[n * 2];
            dfs(n, n, 0, path);

            return ans;
        }

        /**
         * @param p    剩余可以添加的 '('的数量
         * @param q    剩余可以添加的 ')'的数量
         * @param path 存放已添加的 '('或者')',有效长度为：数组长度-p-q
         */
        private void dfs(int p, int q, int index, char[] path) {
            if (p == 0) {
                int L = path.length;
                for (int i = 1; i <= q; i++) path[L - i] = ')';
                ans.add(String.valueOf(Arrays.copyOf(path, L)));
                return;
            }
            //p 不能超过 q
            if (p < q) {
                path[index] = ')';
                dfs(p, q - 1, index + 1, path);
            }
            path[index] = '(';
            dfs(p - 1, q, index + 1, path);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







