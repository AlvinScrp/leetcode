import node.TreeNode;

class A105 {

    public static void main(String[] args) {
        // System.out.println(new A105().new Solution());
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode buildTree(int[] pre, int i, int j, int[] in, int x, int y) {
            if (i > j) return null;
            TreeNode node = new TreeNode(pre[i]);
            if (i == j) return node;
            int L = 0;
            for (int k = x; k <= y; k++) {
                if (in[k] == pre[i]) {
                    L = k - x;
                    break;
                    // x~k-1 左节点   k+1 ~y 右节点
                }
            }
            node.left = buildTree(pre, i + 1, i + L, in, x, x + L - 1);
            node.right = buildTree(pre, i + L + 1, j, in, x + L + 1, y);
            return node;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







