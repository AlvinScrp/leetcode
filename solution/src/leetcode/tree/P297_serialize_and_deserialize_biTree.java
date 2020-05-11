package leetcode.tree;

import java.util.*;

public class P297_serialize_and_deserialize_biTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        Codec codec = new P297_serialize_and_deserialize_biTree().new Codec();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        codec.deserialize(codec.serialize(root));

    }


    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            reserialize(root, sb);
//            System.out.println(sb.substring(1));
            return sb.substring(1);

        }

        private void reserialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(",null");
                return;
            }
            sb.append(",");
            sb.append(root.val);
            reserialize(root.left, sb);
            reserialize(root.right, sb);

        }

        public TreeNode deserialize(String data) {
            if ("".equals(data)) return null;
            String[] ss = data.split(",");
            LinkedList<String> list = new LinkedList<>(Arrays.asList(ss));
            TreeNode root = reDeserialize(list);
            return root;


        }

        private TreeNode reDeserialize(LinkedList<String> list) {
            if (list.isEmpty()) return null;
            String s = list.removeFirst();
            if (s.equals("null")) return null;
            TreeNode node = new TreeNode(Integer.parseInt(s));
            node.left = reDeserialize(list);
            node.right = reDeserialize(list);
            return node;

        }
    }

}
