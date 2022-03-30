import node.TreeNode;

class A129 {

    public static void main(String[] args) {
        //new A129().new Solution()
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
            int ans = sumNumbers(root, 0);
            return ans;

        }

        private int sumNumbers(TreeNode node, int pre) {
            if (node == null) return 0;
            int value = pre * 10 + node.val;
            if (node.left == null && node.right == null) return value;
            return sumNumbers(node.left, value) + sumNumbers(node.right, value);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







