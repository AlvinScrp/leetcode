package leetcode.tree;

public class P104_maxDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int maxDepth(TreeNode root) {
        return maxDepth(root,0);
    }

    public static int maxDepth(TreeNode node, int deep) {

        if (node == null) {
            return deep;
        }

     return Math.max(maxDepth(node.left, deep+1 ), maxDepth(node.right, deep+1));

    }
}
