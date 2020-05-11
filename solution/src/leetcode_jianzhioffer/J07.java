package leetcode_jianzhioffer;

import java.util.HashMap;

public class J07 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    HashMap<Integer, Integer> inorderIndexs;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0) return null;
        if(inorder==null||inorder.length==0) return null;
        inorderIndexs = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexs.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length-1, 0);

    }

    private TreeNode build(int[] preorder, int pstart, int pend, int instart) {
        if (pstart > pend) return null;

        TreeNode node = new TreeNode(preorder[pstart]);
        int inMiddle = inorderIndexs.get(node.val);
        int leftSize = inMiddle - instart;
        node.left = build(preorder, pstart + 1, pstart + leftSize, instart);
        node.right = build(preorder, pstart + 1 + leftSize , pend, inMiddle + 1);
        return node;
    }
}
