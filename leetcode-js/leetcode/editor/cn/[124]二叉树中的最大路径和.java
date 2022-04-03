import node.TreeNode;

class A124 {

    public static void main(String[] args) {
        // System.out.println(new A124().new Solution());
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

        public int dfs(TreeNode node) {
            if (node == null) return 0;
            int l = dfs(node.left);
            int r = dfs(node.right);
            int value = Math.max(node.val, node.val + Math.max(l, r));
            max = Math.max(max, Math.max(value, node.val + l + r));
            return value;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







