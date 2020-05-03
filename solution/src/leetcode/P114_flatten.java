package leetcode;

public class P114_flatten {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode node = root.left;
        while (node != null && node.right != null) {
            node = node.right;
        }
        if (node != null) {
            node.right = root.right;
            root.right = root.left;
            root.left = null;
        }

    }
}
