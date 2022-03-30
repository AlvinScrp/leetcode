import node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class A94 {

    public static void main(String[] args) {
        //new A94().new Solution()
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
        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> ans = new ArrayList<>();
            Stack<TreeNode> s = new Stack<>();
            TreeNode node = root;
            while (true) {
                while (node != null) {
                    s.push(node);
                    node = node.left;
                }
                if (s.isEmpty()) break;
                ans.add(s.peek().val);
                node = s.pop().right;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







