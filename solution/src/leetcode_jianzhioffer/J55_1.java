package leetcode_jianzhioffer;

public class J55_1 {

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode node, int deep) {
        if (node == null) return deep;
        return Math.max(maxDepth(node.left, deep + 1), maxDepth(node.right, deep + 1));
    }
}
