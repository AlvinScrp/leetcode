package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P655 {
    /**
     * 输入:
     * 1
     * / \
     * 2   3
     * \
     * 4
     * 输出:
     * [["", "", "", "1", "", "", ""],
     * ["", "2", "", "", "", "3", ""],
     * ["", "", "4", "", "", "", ""]]
     *
     * @return
     */

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        int maxDeep = maxDeep(root, 0);

        List<TreeNode> nodes = Arrays.asList(root);
        bfs(nodes, 0, maxDeep, res);
        return res;
    }

    private int maxDeep(TreeNode root, int deep) {
        if (root == null) return deep;
        return Math.max(maxDeep(root.left, deep + 1), maxDeep(root.right, deep + 1));

    }

    private void bfs(List<TreeNode> nodes, int deep, int maxDeep, List<List<String>> res) {
        if (deep == maxDeep) return;
        if (!res.isEmpty()) {
            for (List<String> ss : res) {
                List<String> temp = new ArrayList<>(ss);
                ss.clear();
                for (int i = 0; i < temp.size(); i++) {
                    if (i % 2 == 0) ss.add("");
                    ss.add(temp.get(i));
                    if (i % 2 == 0) ss.add("");
                }
            }
        }

        List<TreeNode> children = new ArrayList<>();
        List<String> ss = new ArrayList<>();
        for (TreeNode node : nodes) {
            ss.add(node == null ? "" : String.valueOf(node.val));
            ss.add("");
            children.add(node == null ? null : node.left);
            children.add(node == null ? null : node.right);
        }
        if (!ss.isEmpty()) ss.remove(ss.size() - 1);
        res.add(ss);
        bfs(children, deep + 1, maxDeep, res);
    }

}
