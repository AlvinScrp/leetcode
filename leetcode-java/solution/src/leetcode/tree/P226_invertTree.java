package leetcode.tree;

public class P226_invertTree {

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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;

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
