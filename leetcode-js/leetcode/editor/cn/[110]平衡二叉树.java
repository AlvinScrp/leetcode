import node.TreeNode;

class A110 {

    public static void main(String[] args) {
        // System.out.println(new A110().new Solution());
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
        public boolean isBalanced(TreeNode root) {
            return dfs(root) >= 0;
        }

        private int dfs(TreeNode node) {
            if (node == null) return 0;
            int l = dfs(node.left);
            int r = dfs(node.right);
            if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
                return -1;
            }
            return 1 + Math.max(l, r);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







