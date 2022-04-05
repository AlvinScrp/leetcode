import java.util.LinkedList;
import java.util.List;

class A93 {

    public static void main(String[] args) {
        List<String> ans = new A93().new Solution().restoreIpAddresses("101023");
        for (String an : ans) {
            System.out.print(an + ", ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new LinkedList<>();

        public List<String> restoreIpAddresses(String s) {
            dfs(s, 0, new LinkedList<>());
            return ans;
        }

        private void dfs(String s, int i, LinkedList<String> path) {
            int n = s.length();
            if (path.size() == 4 || i == n) {
                if (path.size() == 4 && i == n) {
                    ans.add(String.join(".",path));
                }
                return;
            }

            for (int j = i; j <= i + 2 && j < s.length(); j++) {
                if (s.charAt(i) == '0' && j > i) break;
                String sub = s.substring(i, j + 1);
                int num = Integer.parseInt(sub);
                if (num > 255) break;
                path.addLast(sub);
                dfs(s, j + 1, path);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







