package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class P538 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode convertBST(TreeNode root) {
        inorder(root, 0);
        return root;
    }

    private int inorder(TreeNode node, int preSum) {
        if (node == null) return preSum;

        preSum = inorder(node.right, preSum);
        System.out.println(preSum);
        node.val = node.val + preSum;

        return inorder(node.left, node.val);
    }
}
