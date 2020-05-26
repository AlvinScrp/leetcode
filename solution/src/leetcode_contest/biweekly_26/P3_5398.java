package leetcode_contest.biweekly_26;

import java.util.ArrayList;
import java.util.List;

public class P3_5398 {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(1);
        root.left.left=new TreeNode(3);
        root.right=new TreeNode(4);
        root.right.left=new TreeNode(1);
        root.right.right=new TreeNode(5);
        new Solution().goodNodes(root);

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        dfs(root, root.val, res);
        return res.size();

    }

    private void dfs(TreeNode node, int max, List<TreeNode> res) {

        if (node == null) return;
        if (node.val >= max) {
            res.add(node);
            System.out.println(node.val);
        }
        max = Math.max(max, node.val);
        dfs(node.left, max, res);
        dfs(node.right, max, res);

    }
}
