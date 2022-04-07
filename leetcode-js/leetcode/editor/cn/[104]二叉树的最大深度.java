import node.TreeNode;

class A104 {

    public static void main(String[] args) {
        // System.out.println(new A104().new Solution());
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
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







