package leetcode.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P589_preorderTreee {

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

    public static List<Integer> preorder(Node root) {


        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.children != null) {
                Collections.reverse(root.children);
                for (Node child : root.children) {
                    stack.push(child);
                }
            }
        }
        return list;

    }
}
