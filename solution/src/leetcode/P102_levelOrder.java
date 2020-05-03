package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P102_levelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        bfs(nodes, 0, res);
        return res;

    }

    private void bfs(List<TreeNode> nodes, int deep, List<List<Integer>> res) {
        if (nodes.isEmpty()) {
            return;
        }
        if (res.size() < deep + 1) {
            res.add(new ArrayList<>());
        }
        List<TreeNode> children = new LinkedList<>();

        for (TreeNode node : nodes) {
            res.get(deep).add(node.val);
            if (node.left != null) children.add(node.left);
            if (node.right != null) children.add(node.right);
        }
        bfs(children, deep + 1, res);

    }
}
