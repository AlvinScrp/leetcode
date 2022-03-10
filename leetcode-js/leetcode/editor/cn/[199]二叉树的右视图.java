import node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class A199 {

    public static void main(String[] args) {
        //new A199().new Solution()
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) return ans;
            LinkedList<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            bfs(nodes, ans);
            return ans;
        }

        private void bfs(LinkedList<TreeNode> nodes, List<Integer> ans) {
            if (nodes == null || nodes.isEmpty()) return;
            LinkedList<TreeNode> children = new LinkedList<>();
            for (TreeNode node : nodes) {
                if (node.left != null) children.add(node.left);
                if (node.right != null) children.add(node.right);
            }
            ans.add(nodes.removeLast().val);
            bfs(children, ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}










