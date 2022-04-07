import node.TreeNode;

class A958 {

    public static void main(String[] args) {
        // System.out.println(new A958().new Solution());
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
        public boolean isCompleteTree(TreeNode root) {
            dfs(root, 1);
            return count == max;
        }

        int count = 0, max = 0;

        private void dfs(TreeNode node, int idx) {
            if (node == null) return;
            count++;
            max = Math.max(max, idx);
            dfs(node.left, idx * 2);
            dfs(node.right, idx * 2 + 1);

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}







