package leetcode.tree;

public class P563 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    int res;

    public int findTilt(TreeNode root) {
        res = 0;
        traversal(root);
        return res;

    }

    private int traversal(TreeNode node) {
        if (node == null) return 0;
        int left = traversal(node.left);
        int right = traversal(node.right);

        res += Math.abs(left - right);
        return left + right + node.val;
    }


}
