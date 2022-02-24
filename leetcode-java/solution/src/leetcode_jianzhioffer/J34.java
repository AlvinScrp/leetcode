package leetcode_jianzhioffer;

import java.util.*;

public class J34 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, sum, path, res);
        return res;


    }

    private void dfs(TreeNode node, int sum, LinkedList<Integer> path, List<List<Integer>> res) {

        if (node == null) return;
        path.add(node.val);
        sum -= node.val;

        if (node.left == null && node.right == null && sum == 0) {
            res.add(new ArrayList<>(path));
        }
        dfs(node.left, sum, path, res);
        dfs(node.right, sum, path, res);
        path.removeLast();
    }
}
