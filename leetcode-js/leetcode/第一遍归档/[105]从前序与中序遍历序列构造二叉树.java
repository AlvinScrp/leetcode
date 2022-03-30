import node.TreeNode;

class A105 {

    public static void main(String[] args) {
        //new A105().new Solution()
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

        private TreeNode buildTree(int[] pre, int x, int y, int[] in, int i, int j) {
            if (x > y) return null;
            TreeNode node = new TreeNode(pre[x]);
            int k = i;
            for (; k <= j; k++) if (in[k] == pre[x]) break;
            int L = k - i;//L为左子树长度
            //i ~ k-1 为in左子树， k+1 ~ j为in的右子树
            node.left = buildTree(pre, x + 1, x + L, in, i, k - 1);
            node.right = buildTree(pre, x + L + 1, y, in, k + 1, j);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







