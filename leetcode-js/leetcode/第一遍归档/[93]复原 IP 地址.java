import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class A93 {

    public static void main(String[] args) {
        System.out.println(new A93().new Solution());

        List<String> ans = new A93().new Solution().restoreIpAddresses("25525511135");
        for (String an : ans) {
            System.out.print(an + " , ");
        }
        System.out.println();

        ans = new A93().new Solution().restoreIpAddresses("0000");
        for (String an : ans) {
            System.out.print(an + " , ");
        }
        System.out.println();

        ans = new A93().new Solution().restoreIpAddresses("101023");
        for (String an : ans) {
            System.out.print(an + " , ");
        }
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> ans = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            dfs(s, 0, 4, new LinkedList<>());
            return ans;

        }

        private void dfs(String s, int start, int leave, LinkedList<String> path) {
            if (leave == 0) {
                if (start == s.length()) {
                    StringBuilder sb = new StringBuilder();
                    for (String s1 : path) {
                        sb.append("." + s1);
                    }
                    ans.add(sb.substring(1));
                }
                return;
            }
            for (int i = start, count = 1; count <= 3 && i + count <= s.length(); count++) {
                String str = s.substring(i, i + count);
                if (str.length() > 1 && str.startsWith("0")) break;
                if (Integer.parseInt(str) > 255) break;
                path.add(str);
                dfs(s, start + count, leave - 1, path);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







