import node.TreeNode;

import java.util.LinkedList;
import java.util.List;

class A662 {

    public static void main(String[] args) {
        // System.out.println(new A662().new Solution());
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
        List<Integer> firstes = new LinkedList<>();
        int max = 0;

        public int widthOfBinaryTree(TreeNode root) {
            dfs(root, 0, 1);
            return max;
        }

        private void dfs(TreeNode node, int h, int idx) {
            if (node == null) return;
            if (firstes.size() == h) {
                firstes.add(idx);
            } else {
                max = Math.max(max, idx - firstes.get(h) + 1);
            }
            dfs(node.left, h + 1, idx << 1);
            dfs(node.right, h + 1, (idx << 1) + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







