package leetcode.p101_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P199_rightSideView {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        LinkedList<TreeNode> nodes = new LinkedList<>();
//        nodes.add(root);
//        levelTraversal(nodes, res);
//        return res;
//    }
//
//    private void levelTraversal(LinkedList<TreeNode> nodes, List<Integer> res) {
//
//        if (nodes == null || nodes.isEmpty()) {
//            return;
//        }
//        res.add(nodes.getLast().val);
//        LinkedList<TreeNode> children = new LinkedList<>();
//        for (TreeNode node : nodes) {
//            if (node.left != null) children.add(node.left);
//            if (node.right != null) children.add(node.right);
//        }
//        levelTraversal(children,res);
//
//    }

    List<Integer> res;

    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level == res.size()) {
            res.add(node.val);
        }
        dfs(node.right, level + 1);
        dfs(node.left, level + 1);
    }


}
