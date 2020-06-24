package leetcode.p201_300;

import java.util.LinkedList;
import java.util.List;

public class P237_binaryTreePaths {

    public static void main(String[] args) {
//        new P110_isBalanced().isBalanced();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        dfs(root, "", res);
        return res;

    }

    private void dfs(TreeNode node, String path, List<String> res) {
        path += ("->" + node.val);
        if (node.left == null && node.right == null) {
            res.add(path.substring(2));
            return;
        }
        if (node.left != null) {
            dfs(node.left, new String(path), res);
        }
        if (node.right != null) {
            dfs(node.right, new String(path), res);
        }

    }


}
