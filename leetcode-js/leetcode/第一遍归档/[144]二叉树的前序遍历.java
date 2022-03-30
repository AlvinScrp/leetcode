import node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class A144 {

    public static void main(String[] args) {
        // System.out.println(new A144().new Solution());
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            Stack<TreeNode> s = new Stack<>();
            s.push(root);
            TreeNode node;
            while (!s.isEmpty()) {
                node = s.pop();
                if (node == null) continue;
                ans.add(node.val);
                s.push(node.right);
                s.push(node.left);
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







