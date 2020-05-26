package leetcode_jianzhioffer;

import java.util.ArrayList;
import java.util.List;

public class J32_3 {

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
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int deep, List<List<Integer>> res) {
        if (node == null) return;
        if (deep == res.size()) res.add(new ArrayList<>());
        if (deep % 2 == 0) {
            res.get(deep).add(node.val);
        } else {
            res.get(deep).add(0, node.val);
        }
        dfs(node.left, deep + 1, res);
        dfs(node.right, deep + 1, res);
    }


}
