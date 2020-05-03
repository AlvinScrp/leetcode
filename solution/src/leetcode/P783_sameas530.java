package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P783_sameas530 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    public int getMinimumDifference(TreeNode root) {
//
//        if (root == null) {
//            return Integer.MAX_VALUE;
//        }
//        int left = Integer.MAX_VALUE;
//        if (root.left != null) {
//            TreeNode node = root.left;
//            while (node.right != null) {
//                node = node.right;
//            }
//            left = root.val - node.val;
//        }
//        int right = Integer.MAX_VALUE;
//        if (root.right != null) {
//            TreeNode node = root.right;
//            while (node.left != null) {
//                node = node.left;
//            }
//            right = node.val - root.val;
//        }
//
//      return   Math.min(left, Math.min(right, Math.min(getMinimumDifference(root.left), getMinimumDifference(root.right))));
//
//    }

    public int getMinimumDifference2(TreeNode root) {

        List<Integer> values = new LinkedList<>();
        ldr(root, values);
        int length = values.size();
        List<Integer> values2 = new ArrayList<>(values);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length - 1; i++) {
            min = Math.min(values2.get(i + 1) - values2.get(i), min);
        }
        return min;


    }

    private void ldr(TreeNode node, List<Integer> values) {
        if(node==null){
            return;
        }
        ldr(node.left,values);
        values.add(node.val);
        ldr(node.right,values);
    }
}
