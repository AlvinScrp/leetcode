import node.TreeNode;

class A543 {

    public static void main(String[] args) {
        // System.out.println(new A543().new Solution());
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
        int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return max;
        }

        private int dfs(TreeNode root) {
            if (root == null) return 0;
            int lh = dfs(root.left);
            int rh = dfs(root.right);

            max = Math.max(max, lh + rh );
            return Math.max(lh, rh) + 1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







