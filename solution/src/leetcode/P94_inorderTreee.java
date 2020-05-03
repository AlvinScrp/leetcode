package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P94_inorderTreee {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new LinkedList<>();

        TreeNode x = root;
        while (true) {
            pushLeft(x, s);
            if (s.isEmpty()) break;
            TreeNode node = s.pop();
            res.add(node.val);
            x = node.right;
        }
        return res;

    }

    public void pushLeft(TreeNode node, Stack<TreeNode> s) {
        while (node != null) {
            s.push(node);
            node = node.left;
        }
    }


    /**
     * 先序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new LinkedList<>();

        TreeNode x = root;
        while (true) {
            visitLeft(x, s, res);
            if (s.isEmpty()) break;
            x = s.pop();
        }

        return res;

    }

    public void visitLeft(TreeNode node, Stack<TreeNode> s, List<Integer> res) {
        while (node != null) {
            res.add(node.val);
            s.push(node.right);
            node = node.left;
        }
    }
}
