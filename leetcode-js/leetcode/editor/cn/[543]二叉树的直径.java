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


        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return max - 1;
        }

        int max = 0;

        private int dfs(TreeNode node) {
            if (node == null) return 0;

            int left = dfs(node.left);
            int right = dfs(node.right);
            int sum = 1 + left + right;
            max = Math.max(max, sum);
            return Math.max(left, right) + 1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}







