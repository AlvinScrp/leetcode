import node.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class A102 {

//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            List<TreeNode> nodes = Arrays.asList(root);
            levelOrder(nodes, res);
            return res;
        }

        private void levelOrder(List<TreeNode> nodes, List<List<Integer>> res) {
            if (nodes == null || nodes.isEmpty()) return;
            List<Integer> values = new ArrayList<>();
            List<TreeNode> children = new ArrayList<>();
            for (TreeNode node : nodes) {
                values.add(node.val);
                if (node.left != null) children.add(node.left);
                if (node.right != null) children.add(node.right);
            }
            res.add(values);
            levelOrder(children, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}