package leetcode_jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class J32_1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new LinkedList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        levelOrderInner(nodes, list);
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer val : list) {
            res[i++] = val;
        }
        return res;
    }

    private void levelOrderInner(List<TreeNode> nodes, List<Integer> list) {
        if (nodes != null && !nodes.isEmpty()) {
            List<TreeNode> children = new ArrayList<>();
            for (TreeNode node : nodes) {
                list.add(node.val);
                if (node.left != null) children.add(node.left);
                if (node.right != null) children.add(node.right);
            }
            levelOrderInner(children,list);
        }
    }
}
