package leetcode;

public class P111_min_depth {

    public static void main(String[] args) {
//        new P110_isBalanced().isBalanced();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minDeep(root, 0) + 1;

    }

    public static int minDeep(TreeNode node, int step) {
        if (node == null) {
            return step - 1;
        }
        int left = minDeep(node.left, step + 1);
        int right = minDeep(node.right, step + 1);
        return (node.left != null && node.right != null) ? Math.min(left, right) : (node.left != null ? left : right);
    }
}
