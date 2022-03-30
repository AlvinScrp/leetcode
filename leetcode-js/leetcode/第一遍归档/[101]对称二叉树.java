import node.TreeNode;

class A101 {

    public static void main(String[] args) {
        //new A101().new Solution()
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
        public boolean isSymmetric(TreeNode root) {
            return isSymmetric(root.left, root.right);

        }

        private boolean isSymmetric(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) return true;
            if ((node1 == null || node2 == null) || node1.val != node2.val) return false;
            return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







