package leetcode.tree;

public class P543 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        d_gain(root);
        return max - 1;

    }

    private int d_gain(TreeNode node) {
        if (node == null) return 0;
        int left = d_gain(node.left);
        int right = d_gain(node.right);
        max = Math.max(left + right + 1, max);
        return Math.max(left, right) + 1;
    }
}
