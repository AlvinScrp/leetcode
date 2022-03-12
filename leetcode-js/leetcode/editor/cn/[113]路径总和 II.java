import node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class A113 {

    public static void main(String[] args) {
        //new A113().new Solution()
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
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            LinkedList path = new LinkedList();
            pathSum(root, targetSum, path);
            return ans;

        }

        private void pathSum(TreeNode node, int targetSum, LinkedList path) {
            if (node == null) return;

            if (node.left == null && node.right == null) {
                if (targetSum == node.val) {
                    path.add(node.val);
                    ans.add(new ArrayList<>(path));
                    path.removeLast();
                }
                return;
            }
            path.add(node.val);
            pathSum(node.left, targetSum - node.val, path);
            pathSum(node.right, targetSum - node.val, path);
            path.removeLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







