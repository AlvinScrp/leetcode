package leetcode;

public class P112_hasPathSum {

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

    public static boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);

    }

    private static boolean dfs(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        sum -= node.val;
        if (node.left == null && node.right == null) {
            return sum == 0;
        }
        return dfs(node.left, sum) || dfs(node.right, sum);


    }


}
