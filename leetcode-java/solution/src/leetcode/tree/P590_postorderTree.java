package leetcode.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P590_postorderTree {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static List<Integer> postorder(Node root) {

        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack();
        Node node=root;
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            list.addFirst(node.val);
            if (node.children != null) {
                for (Node child : node.children) {
                    stack.push(child);
                }
            }
        }
        return list;

    }
}
