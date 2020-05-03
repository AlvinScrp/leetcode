package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P102_zigzagLevelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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

        boolean start = deep % 2 == 1;

        for (TreeNode node : nodes) {
            if (start) {
                res.get(deep).add(0, node.val);
            } else {
                res.get(deep).add(node.val);
            }
            if (node.left != null) children.add(node.left);
            if (node.right != null) children.add(node.right);
        }
        bfs(children, deep + 1, res);

    }
}
