package leetcode.p101_200;

import java.util.ArrayList;
import java.util.List;

public class P116_connect {

    public class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node(int x) {
            val = x;
        }

//        public Node connect(Node root) {
//            if (root == null) {
//                return root;
//            }
//            List<Node> nodes = new ArrayList<>();
//            nodes.add(root);
//            levelOrder(nodes);
//            return root;
//
//        }
//
//        private void levelOrder(List<Node> nodes) {
//            if (nodes == null || nodes.isEmpty()) {
//                return;
//            }
//
//            for (int i = 0; i < nodes.size() - 1; i++) {
//                nodes.get(i).next = nodes.get(i + 1);
//            }
//            List<Node> children = new ArrayList<>();
//            for (Node node : nodes) {
//                if (node.left != null) {
//                    children.add(node.left);
//                    children.add(node.right);
//                }
//            }
//            levelOrder(children);
//        }

        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            Node node = root;
            if (node.left != null) {
                node.left.next = node.right;
                if (node.next != null) {
                    node.right.next = node.next.left;
                }
            }
            connect(root.left);
            connect(root.right);
            return root;

        }


    }

}
