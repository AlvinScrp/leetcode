package leetcode.tree;

public class P671 {

    int min, secondMin;

    public int findSecondMinimumValue(TreeNode root) {
        min = secondMin = root.val;
        dfs(root);
        return secondMin == min ? -1 : secondMin;

    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.val != min) {
            secondMin = secondMin == min ? root.val : Math.min(secondMin, root.val);
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
