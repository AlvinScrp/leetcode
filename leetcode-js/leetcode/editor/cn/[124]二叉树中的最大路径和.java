import node.TreeNode;

class A124 {

    public static void main(String[] args) {
        //new A124().new Solution()
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

        int max = -1001;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return max;

        }

        private int dfs(TreeNode node) {
            if (node == null) return -1001;

            int left = dfs(node.left);
            int right = dfs(node.right);

            //dp表示node可参与上层连接
            int dp = Math.max(node.val, node.val + Math.max(left, right));
            max = Math.max(max, Math.max(dp, node.val + left + right));
            return dp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







