package leetcode.tree;

public class P623 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 输入:
     * 二叉树如下所示:
     * 4
     * /   \
     * 2     6
     * / \   /
     * 3   1 5
     * <p>
     * v = 1
     * <p>
     * d = 2
     * <p>
     * 输出:
     * 4
     * / \
     * 1   1
     * /     \
     * 2       6
     * / \     /
     * 3   1   5
     *
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        dfs(root, 1, v, d);
        return root;

    }

    private void dfs(TreeNode node, int i, int v, int d) {
        if (node == null) return;
        if (i == d - 1) {
            TreeNode left = new TreeNode(v);
            left.left = node.left;
            node.left = left;

            TreeNode right = new TreeNode(v);
            right.right = node.right;
            node.right = right;
            return;
        }
        dfs(node.left, i + 1, v, d);
        dfs(node.right, i + 1, v, d);
    }

}
