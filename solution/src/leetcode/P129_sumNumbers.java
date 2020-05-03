package leetcode;

public class P129_sumNumbers {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        dfs(root, 0);
        return sum;

    }

    private void dfs(TreeNode root, int current) {
        if (root == null) {
            return;
        }
        current = current * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += current;
        }
        dfs(root.left, current);
        dfs(root.right, current);
    }
}
