package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P110_isBalanced {

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

    //    public boolean isBalanced(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        int leftH = getHeight(root.left);
//        int rightH = getHeight(root.right);
//        if (Math.abs(leftH - rightH) > 1) {
//            return false;
//        }
//        return isBalanced(root.left) && isBalanced(root.right);
//
//    }
//
//    public int getHeight(TreeNode node) {
//        if (node == null) {
//            return -1;
//        }
//        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
//    }
    public static boolean isBalanced(TreeNode root) {
        int[] res = isBalancedInner(root);
        return res[0] == 1;

    }

    public static int[] isBalancedInner(TreeNode node) {

        if (node == null) {
            return new int[]{1, -1};
        }
        int[] res = new int[]{0, -1};
        int[] left = isBalancedInner(node.left);
        if (left[0] == 0) return res;
        int[] right = isBalancedInner(node.right);
        if (right[0] == 0) return res;
        if (Math.abs(left[1] - right[1]) > 1) return res;
        res[0] = 1;
        res[1] = 1 + Math.max(left[1], right[1]);
        return res;

    }


}
