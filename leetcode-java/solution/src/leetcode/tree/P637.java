package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class P637 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 输入:
     * 二叉树如下所示:
     * 4
     * /   \
     * 2     6
     * / \   /
     * 3   1 5
     * <p>
     * v = 1
     * <p>
     * d = 2
     * <p>
     * 输出:
     * 4
     * / \
     * 1   1
     * /     \
     * 2       6
     * / \     /
     * 3   1   5
     *
     * @return
     */
    List<List<Integer>> res;

    public List<Double> averageOfLevels(TreeNode root) {
        res = new LinkedList<>();
        dfs(root, 0);
        List<Double> doubles = new LinkedList<>();
        for (List<Integer> list : res) {
            long sum=0;
            for (Integer integer : list) {
                sum+=integer;
            }
            doubles.add(sum * 1.0 / list.size());
        }
        return doubles;

    }

    private void dfs(TreeNode node, int deep) {
        if (node == null) return;
        if (deep == res.size()) res.add(new LinkedList<>());
        res.get(deep).add(node.val);
        dfs(node.left, deep + 1);
        dfs(node.right, deep + 1);
    }


}
