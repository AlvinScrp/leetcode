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
            return f(root) != -1;
        }

        private int f(TreeNode node) {
            if (node == null) return 0;
            int lh = f(node.left);
            int rh = f(node.right);
            return (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) ?
                    -1 : (Math.max(lh, rh) + 1);
           
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







