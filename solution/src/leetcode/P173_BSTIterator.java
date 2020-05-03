package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class P173_BSTIterator {

    public static void main(String[] args) {
//        BSTIterator obj = new BSTIterator(root);
//        int param_1 = obj.next();
//        boolean param_2 = obj.hasNext();
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //    class BSTIterator {
//        private Iterator<Integer> iterator;
//
//
//        public BSTIterator(TreeNode root) {
//            List<Integer> list = inorder(root);
//            iterator = list.iterator();
//
//        }
//
//        public int next() {
//            return iterator.next();
//
//        }
//
//        public boolean hasNext() {
//            return iterator.hasNext();
//
//        }
//
//        public List<Integer> inorder(TreeNode root) {
//            List<Integer> res = new ArrayList<>();
//            Stack<TreeNode> stack = new Stack<>();
//            TreeNode node = root;
//            while (true) {
//                if (node != null) {
//                    stack.add(node);
//                    node = node.left;
//                } else if (!stack.isEmpty()) {
//                    node = stack.pop();
//                    res.add(node.val);
//                    node = node.right;
//                } else {
//                    break;
//                }
//            }
//            return res;
//
//        }
//    }
    class BSTIterator {

        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            visitLeft(root, stack);
        }

        public int next() {
            TreeNode node = stack.pop();
            visitLeft(node.right, stack);
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void visitLeft(TreeNode node, Stack<TreeNode> stack) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }


}
