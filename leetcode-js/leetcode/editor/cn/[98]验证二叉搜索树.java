import node.TreeNode;

import java.util.LinkedList;

class A98 {

    public static void main(String[] args) {
        //new A98().new Solution()
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
        LinkedList<Integer> values = new LinkedList<>();

        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;

            if (!isValidBST(root.left)) return false;
            if (!values.isEmpty() && values.getLast() >= root.val) return false;
            values.add(root.val);
            if (!isValidBST(root.right)) return false;
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







