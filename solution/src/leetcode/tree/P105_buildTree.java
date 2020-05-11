package leetcode.tree;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class P105_buildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> inorderIndexs = new HashMap<>();

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        for (int i = 0; i < inorder.length; i++) {
//            inorderIndexs.put(inorder[i], i);
//        }
//        return buildTree(preorder, 0, 0, inorder.length - 1);
//    }
//
//    private TreeNode buildTree(int[] preorder, int preOrderStart, int inorderStart, int inorderEnd) {
//        if (inorderStart > inorderEnd) {
//            return null;
//        }
//        int middleValue = preorder[preOrderStart];
//        TreeNode root = new TreeNode(middleValue);
//
//        int inorderMiddle = inorderIndexs.get(middleValue);
//        int leftSize = inorderMiddle - inorderStart;
//        if (inorderMiddle < 0) {
//            return null;
//        }
//
//        root.left = buildTree(preorder, preOrderStart + 1, inorderStart, inorderMiddle - 1);
//        root.right = buildTree(preorder, preOrderStart + leftSize + 1, inorderMiddle + 1, inorderEnd);
//
//        return root;
//
//    }


}
