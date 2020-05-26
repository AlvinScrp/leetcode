package leetcode_jianzhioffer;

public class J55_2 {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;

        return isBalanced(root.left)
                && isBalanced(root.right)
                && Math.abs(maxDepth(root.left,0) - maxDepth(root.right,0)) <= 1;

    }

    private int maxDepth(TreeNode node, int deep) {
        if (node == null) return deep;
        return Math.max(maxDepth(node.left, deep + 1), maxDepth(node.right, deep + 1));
    }
}
