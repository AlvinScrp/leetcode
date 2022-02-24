package leetcode.tree;

import java.util.*;

public class P145_postorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new LinkedList<>();
//        postorderTraversal(root, res);
//        return res;
//    }
//
//    public void postorderTraversal(TreeNode root, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        postorderTraversal(root.left,res);
//        postorderTraversal(root.right,res);
//        res.add(root.val);
//
//    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;

        postorderTraversal(node1);
    }
//-------------------------------------------------------------------------------------------------
//    public static List<Integer> postorderTraversal(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        List<Integer> res = new LinkedList<>();
//        postorderTraversal(root, stack, res);
//
//        return res;
//    }

//    public static void postorderTraversal(TreeNode root, Stack<TreeNode> stack, List<Integer> res) {
//
//        if (root == null) {
//            return;
//        }
//        TreeNode node = root;
//        while (true) {
//            visitLeft(node, stack);
//            if (stack.isEmpty()) {
//                break;
//            }
//            node = stack.pop();
//            if (!stack.isEmpty() && node.equals(stack.peek())) {
//                node = node.right;
//            } else {
//                res.add(node.val);
//                node = null;
//            }
//        }
//
//    }
//
//    private static void visitLeft(TreeNode node, Stack<TreeNode> stack) {
//
//        while (node != null) {
//            stack.push(node);
//            stack.push(node);
//            node = node.left;
//        }
//    }

    //-------------------------------------------------------------------------------------------------

//    public static void postorderTraversal(TreeNode root, Stack<TreeNode> stack, List<Integer> res) {
//
//        if (root == null) {
//            return;
//        }
//        Set<TreeNode> visited = new HashSet<>();
//        TreeNode node = root;
//        while (true) {
//            visitLeft(node, stack);
//            if (stack.isEmpty()) {
//                break;
//            }
//            node = stack.pop();
//
//            if (!visited.contains(node)) {
//                stack.push(node);
//                visited.add(node);
//                node = node.right;
//
//            } else {
//                res.add(node.val);
//                node = null;
//
//            }
//        }
//
//    }
//
//    private static void visitLeft(TreeNode node, Stack<TreeNode> stack) {
//
//        while (node != null) {
//            stack.push(node);
//            node = node.left;
//        }
//    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.addFirst(node.val);
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
        }
        return res;
    }

}
