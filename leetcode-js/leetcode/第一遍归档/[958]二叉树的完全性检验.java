import node.TreeNode;

import java.util.LinkedList;

class A958 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6), null));
        System.out.println(new A958().new Solution().isCompleteTree(node));
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
        public boolean isCompleteTree(TreeNode root) {

            LinkedList<TreeNode> q = new LinkedList<>();
            q.add(root);
            boolean end = false;
            while (!q.isEmpty()) {

                TreeNode node = q.pollFirst();
                if (end) {
                    if (node.left != null || node.right != null) return false;
                    continue;
                }

                if (node.left == null) {
                    if (node.right != null) return false;
                    end = true;
                } else {
                    q.addLast(node.left);
                    if (node.right == null) {
                        end = true;
                    } else {
                        q.addLast(node.right);
                    }
                }
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







