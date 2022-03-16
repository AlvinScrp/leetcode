import node.TreeNode;

import java.util.ArrayList;
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

        List<Integer> levelStarts = new ArrayList<>();
        int max = 0;

        public int widthOfBinaryTree(TreeNode root) {
            dfs(root, 0, 1);
            return max;
        }

        private void dfs(TreeNode node, int level, int index) {
            if (node == null) return;
            if (levelStarts.size() == level) levelStarts.add(index);
            max = Math.max(max, index - levelStarts.get(level) + 1);
            dfs(node.left, level + 1, index << 1);
            dfs(node.right, level + 1, (index << 1) + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







