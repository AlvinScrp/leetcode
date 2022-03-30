import node.TreeNode;

class A112 {

    public static void main(String[] args) {
        //new A112().new Solution()
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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            targetSum -= root.val;
            if (root.left == null && root.right == null) return targetSum == 0;
            return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}







