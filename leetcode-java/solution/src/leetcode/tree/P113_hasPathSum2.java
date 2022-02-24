package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P113_hasPathSum2 {

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


    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(root, sum, path, res);
        return res;

    }

    private static void dfs(TreeNode node, int sum, List<Integer> path, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (node.left != null) {
            dfs(node.left, sum, path, res);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            dfs(node.right, sum, path, res);
            path.remove(path.size() - 1);
        }


    }


}
