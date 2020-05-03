package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P98_isValidBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null;
        while (true) {
            visitLeft(node, stack);
            if (stack.isEmpty()) {
                break;
            }
            node = stack.pop();
            if (pre != null && pre.val >= node.val) {
                return false;
            }
            pre = node;
            node = node.right;

        }
        return true;

    }

    private void visitLeft(TreeNode node, Stack<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
