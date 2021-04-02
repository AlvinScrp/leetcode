package leetcode.p401_500;

public class P437_pathSum {

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

    public int pathSum(TreeNode root, int sum) {
        int count = dfs(root, root, sum, sum);
        return count;
    }

    private static int dfs(TreeNode node, TreeNode start, int current, int sum) {
        if (node == null) {
            return 0;
        }
        current -= node.val;
        int count = 0 == current ? 1 : 0;
        count = count
                + dfs(node.right, start, current, sum)
                + dfs(node.left, start, current, sum);
        if (node == start) {
            count = count + dfs(node.right, node.right, sum, sum)
                    + dfs(node.left, node.left, sum, sum);
        }
        return count;
    }


}
