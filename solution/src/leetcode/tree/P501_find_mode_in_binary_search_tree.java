package leetcode.tree;

import java.util.*;

public class P501_find_mode_in_binary_search_tree {
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
        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(2);

        findMode(root);

    }


    public static int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        num = count = maxCount = 0;
        inorder(root, res);

        System.out.println(res);
        int[] array = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }

        return array;
    }

    static int num, count, maxCount;

    public static void inorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorder(node.left, res);
        if (res.isEmpty()) {
            num = node.val;
            count = 1;
            maxCount = 1;
            res.add(node.val);
        } else if (node.val == num) {
            count++;
            if (count > maxCount) {
                res.clear();
                res.add(num);
                maxCount=count;
            } else if (count == maxCount) {
                res.add(num);
            }
        } else {
            num = node.val;
            count = 1;
            if(count==maxCount){
                res.add(num);
            }
        }
        inorder(node.right, res);
    }

}
