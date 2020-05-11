package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P515 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ArrayList<Integer> res;

    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        return res;

    }

    private void dfs(TreeNode node, int deep) {
        if (node == null) return;
        if (deep == res.size()) {
            res.add(node.val);
        } else if (res.get(deep) < node.val) {
            res.remove(deep);
            res.add(deep, node.val);
        }
        dfs(node.left, deep + 1);
        dfs(node.right, deep + 1);


    }
}
