import node.TreeNode;

import java.util.LinkedList;
import java.util.List;

class A102 {

    public static void main(String[] args) {
        // System.out.println(new A102().new Solution());
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

        List<List<Integer>> ans = new LinkedList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            dfs(root, 0);
            return ans;
        }

        private void dfs(TreeNode node, int h) {
            if (node == null) return;
            if (ans.size() == h) ans.add(new LinkedList<>());
            ans.get(h).add(node.val);
            dfs(node.left, h + 1);
            dfs(node.right, h + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







