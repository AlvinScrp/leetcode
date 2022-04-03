import node.TreeNode;

import java.util.LinkedList;
import java.util.List;

class A199 {

    public static void main(String[] args) {
        // System.out.println(new A199().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new LinkedList<>();
            dfs(root, 0, ans);
            return ans;
        }

        private void dfs(TreeNode node, int h, List<Integer> ans) {
            if (node == null) return;
            if (h == ans.size()) {
                ans.add(node.val);
            }
            dfs(node.right, h + 1, ans);
            dfs(node.left, h + 1, ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







