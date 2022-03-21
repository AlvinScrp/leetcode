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
        int ans = -1;

        public int kthSmallest(TreeNode root, int k) {
            dfs(root, k);
            return ans;

        }

        private int dfs(TreeNode node, int k) {
            if (node == null) return k;
            int leave = dfs(node.left, k);
            if (leave == 1) {
                ans = node.val;
                return 0;
            }
            return dfs(node.right, leave - 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







