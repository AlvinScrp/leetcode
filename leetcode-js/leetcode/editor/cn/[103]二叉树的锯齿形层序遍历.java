import node.TreeNode;

import java.util.LinkedList;
import java.util.List;

class A103 {

    public static void main(String[] args) {
        // System.out.println(new A103().new Solution());
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
        List<List<Integer>> ans = new LinkedList<>();

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            zigzag(nodes, false);
            return ans;


        }

        private void zigzag(List<TreeNode> nodes, boolean reverse) {
            if (nodes == null || nodes.isEmpty()) return;
            LinkedList<Integer> values = new LinkedList<>();
            List<TreeNode> children = new LinkedList<>();
            for (TreeNode node : nodes) {
                if (node == null) continue;
                children.add(node.left);
                children.add(node.right);
                if (reverse) {
                    values.addFirst(node.val);
                } else {
                    values.addLast(node.val);
                }
            }
            if (!values.isEmpty()) {
                ans.add(values);
            }

            zigzag(children, !reverse);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







