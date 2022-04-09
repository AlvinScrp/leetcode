import node.TreeNode;

class A230 {

    public static void main(String[] args) {
        // System.out.println(new A230().new Solution());
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
        int ans, count;

        public int kthSmallest(TreeNode root, int k) {
            count = k;
            dfs(root);
            return ans;


        }

        private void dfs(TreeNode node) {
            if (count == 0) return;
            if (node == null) return;
            dfs(node.left);
            if ((--count) == 0) {
                ans = node.val;
                return;
            }
            dfs(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







