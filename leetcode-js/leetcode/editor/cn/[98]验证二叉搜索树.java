import node.TreeNode;

class A98 {

    public static void main(String[] args) {
        // System.out.println(new A98().new Solution());
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
        Integer pre = null;
        public boolean isValidBST(TreeNode root) {
            return dfs(root);
        }

        private boolean dfs(TreeNode node) {
            if (node == null) return true;
            if (!dfs(node.left)) return false;
            if (pre != null && pre >= node.val) return false;
            pre = node.val;
            return dfs(node.right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







