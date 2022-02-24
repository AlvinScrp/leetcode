package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P513 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res;
    int resDeep;

    public int findBottomLeftValue(TreeNode root) {
        if(root==null){
            return 0;
        }
        res = 0;
        resDeep = -1;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int deep) {
        if (node == null) return;

        if (resDeep < deep) {
            res = node.val;
            resDeep = deep;
        }
        dfs(node.left, deep + 1);
        dfs(node.right, deep + 1);
    }
}
