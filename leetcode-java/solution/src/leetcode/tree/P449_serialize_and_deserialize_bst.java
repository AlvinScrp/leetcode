package leetcode.tree;

import java.util.*;
import java.util.stream.Collectors;

public class P449_serialize_and_deserialize_bst {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

//        Codec codec = new P449_serialize_and_deserialize_bst().new Codec();
//
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.left.right = new TreeNode(2);
//        root.right = new TreeNode(4);
//        codec.deserialize(codec.serialize(root));

    }


//    public class Codec {
//
//
//        // Encodes a tree to a single string.
//        public String serialize(TreeNode root) {
//            if (root == null) {
//                return "";
//            }
//
//            TreeNode node = root;
//            Stack<TreeNode> stack = new Stack<>();
//            StringBuilder sb = new StringBuilder();
//            while (true) {
//                while (node != null) {
//                    stack.push(node.right);
//                    sb.append(",");
//                    sb.append(node.val);
//                    node = node.left;
//                }
//                if (stack.isEmpty()) break;
//                node = stack.pop();
//            }
//
//            String resStr = sb.toString();
//            resStr= resStr.substring(1);
////            System.out.println(resStr);
//            return resStr;
//
//        }
//
//
//        Map<Integer, Integer> inorderIndexs;
//
//        // Decodes your encoded data to tree.
//        public TreeNode deserialize(String data) {
//            if (data == null || data.equals("")) {
//                return null;
//            }
//            String[] ss = data.split(",");
//            int[] preorder = new int[ss.length];
//            int[] inorder = new int[ss.length];
//             inorderIndexs = new HashMap<>();
//            for (int i = 0; i < ss.length; i++) {
//                preorder[i] = Integer.parseInt(ss[i]);
//                inorder[i] = preorder[i];
//
//            }
//            Arrays.sort(inorder);
//            for (int i = 0; i < inorder.length; i++) {
//                inorderIndexs.put(inorder[i], i);
//            }
//
//            TreeNode root = buildTree(preorder, 0, preorder.length-1, 0);
//            return root;
//
//        }
//
//        private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int iStart) {
//            if (pStart > pEnd) {
//                return null;
//            }
//
//            TreeNode node = new TreeNode(preorder[pStart]);
//            if (pStart == pEnd) {
//                return node;
//            }
//
//            int iMiddle = inorderIndexs.get(preorder[pStart]);
//            int leftSize = iMiddle - iStart;
//            TreeNode left = buildTree(preorder, pStart + 1, pStart + leftSize, iStart);
//            TreeNode right = buildTree(preorder, pStart + 1 + leftSize, pEnd, iMiddle + 1);
//            node.left = left;
//            node.right = right;
//            return node;
//        }
//
//    }

}
