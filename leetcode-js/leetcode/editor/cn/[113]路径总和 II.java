import node.TreeNode;

import java.util.LinkedList;
import java.util.List;

class A113 {

    public static void main(String[] args) {
        // System.out.println(new A113().new Solution());
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ans = new LinkedList<>();
            pathSum(root, targetSum, new LinkedList<>(), ans);
            return ans;

        }

        private void pathSum(TreeNode node, int sum, LinkedList<Integer> path, List<List<Integer>> ans) {
            if (node == null) return;
            path.add(node.val);
            if (node.left == null && node.right == null && sum == node.val) {
                ans.add(new LinkedList<>(path));
            }
            pathSum(node.left, sum - node.val, path, ans);
            pathSum(node.right, sum - node.val, path, ans);
            path.removeLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







