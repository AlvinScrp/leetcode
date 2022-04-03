import node.TreeNode;

class A129 {

    public static void main(String[] args) {
        // System.out.println(new A129().new Solution());
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

        public int sumNumbers(TreeNode root) {
            return dfs(root, 0);
        }

        private int dfs(TreeNode node, int pre) {
            if (node == null) return 0;
            int value = pre * 10 + node.val;
            if (node.left == null && node.right == null) {
                return value;
            }
            return dfs(node.left, value) + dfs(node.right, value);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







