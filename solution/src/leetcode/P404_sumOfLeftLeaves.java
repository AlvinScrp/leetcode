package leetcode;

import java.util.LinkedList;
import java.util.List;

public class P404_sumOfLeftLeaves {

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

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, 0, false);
    }

    private int dfs(TreeNode node, int current, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return current + (isLeft ? node.val : 0);
        }
        return dfs(node.left, current, true) + dfs(node.right, current, false);
    }


}
