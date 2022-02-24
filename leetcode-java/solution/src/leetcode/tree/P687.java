package leetcode.tree;

public class P687 {

    int max;

    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        arrowLength(root);
        return max;
    }

    private int arrowLength(TreeNode node) {

        if (node == null) return 0;
        int arrowLeft = 0, arrowRight = 0;

        int left = arrowLength(node.left);
        int right = arrowLength(node.right);

        if (valueEqual(node, node.left)) {
            arrowLeft = left + 1;
        }
        if (valueEqual(node, node.right)) {
            arrowRight = right + 1;
        }

        max = Math.max(max, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

    private boolean valueEqual(TreeNode node, TreeNode child) {
        return child != null && node.val == child.val;
    }


}
