import node.TreeNode;

class A114 {

    public static void main(String[] args) {
        // System.out.println(new A114().new Solution());
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


        public void flatten(TreeNode root) {
            traverse(root);
        }

        private TreeNode traverse(TreeNode node) {
            if (node == null) return null;

            TreeNode left = node.left;
            TreeNode right = node.right;
            TreeNode tail = node;
            TreeNode leftTail = traverse(left);
            tail = connect(tail, left, leftTail);

            TreeNode rightTail = traverse(right);
            tail = connect(tail, right, rightTail);
            node.left = null;

            return tail;

        }

        private TreeNode connect(TreeNode tail, TreeNode nextHead, TreeNode nextTail) {
            if (nextHead != null) {
                tail.right = nextHead;
                tail = nextTail;
            }
            return tail;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







