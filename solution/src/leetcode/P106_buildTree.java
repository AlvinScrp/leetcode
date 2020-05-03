package leetcode;

import java.util.HashMap;
import java.util.Map;

public class P106_buildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        new P106_buildTree().buildTree(new int[]{},new int[]{});

    }
    Map<Integer, Integer> inorderIndexs = new HashMap<>();

    public TreeNode buildTree( int[] inorder,int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexs.put(inorder[i], i);
        }
        return buildTree(postorder, postorder.length-1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int postOrderStart, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }
        int middleValue = postorder[postOrderStart];
        TreeNode root = new TreeNode(middleValue);

        int inorderMiddle = inorderIndexs.get(middleValue);
        int leftSize = inorderMiddle - inorderStart;
        int rightSize=inorderEnd-inorderMiddle;
        if (inorderMiddle < 0) {
            return null;
        }

        root.left = buildTree(postorder, postOrderStart-rightSize - 1, inorderStart, inorderMiddle - 1);
        root.right = buildTree(postorder, postOrderStart - 1, inorderMiddle + 1, inorderEnd);

        return root;

    }


}
