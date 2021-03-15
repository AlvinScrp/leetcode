package leetcode_fuxi20201208;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P94_orderTreee {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        System.out.println(new P94_orderTreee().preorderTraversal(root));
        System.out.println(new P94_orderTreee().inorderTraversal(root));
        System.out.println(new P94_orderTreee().postOrderTraversal(root));

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

        TreeNode node = root;
        while (true) {
            while (node != null) {
                s.add(node);
                node = node.left;
            }
            if (s.isEmpty()) break;
            node = s.pop();
            res.add(node.val);
            node = node.right;
        }


        return res;

    }


    /**
     * 先序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        TreeNode node = root;
        while (true) {
            while (node != null) {
                res.add(node.val);
                s.add(node.right);
                node = node.left;
            }
            if (s.isEmpty()) break;
            node = s.pop();

        }
        return res;
    }


    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        TreeNode node = root;
        while (true) {

            while (node != null) {
                s.add(node);
                s.add(node);
                node = node.left;
            }
            if (s.isEmpty()) break;
            node = s.pop();
            if (!s.isEmpty() && node == s.peek()) {
                node = node.right;
            } else {
                res.add(node.val);
                node = null;
            }
        }

        return res;
    }


}
