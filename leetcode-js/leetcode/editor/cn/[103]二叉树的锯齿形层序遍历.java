import node.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class A103 {

    public static void main(String[] args) {

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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            List<TreeNode> nodes = Arrays.asList(root);
            levelOrder(nodes, false, res);
            return res;
        }

        private void levelOrder(List<TreeNode> nodes, boolean rightFirst, List<List<Integer>> res) {
            if (nodes == null || nodes.isEmpty()) return;
            List<Integer> values = new ArrayList<>();
            List<TreeNode> children = new ArrayList<>();
            for (TreeNode node : nodes) {
                values.add(node.val);
                if (node.left != null) children.add(node.left);
                if (node.right != null) children.add(node.right);
            }
            if (rightFirst) Collections.reverse(values);
            res.add(values);
            levelOrder(children, !rightFirst, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}