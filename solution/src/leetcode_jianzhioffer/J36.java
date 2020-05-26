package leetcode_jianzhioffer;

import java.util.Stack;

public class J36 {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);
        Node head = treeToDoublyList2(root);
        System.out.println(head);

    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

//    public static Node treeToDoublyList(Node root) {
//        if (root == null) return null;
//
//        Node ans = root;
//        Node pre = treeToDoublyList(root.left);
//        Node next = treeToDoublyList(root.right);
//        ans.left = ans;
//        ans.right = ans;
//        if (pre != null) ans = merge(pre, ans);
//        if (next != null) ans = merge(ans, next);
//        return ans;
//    }

    public static Node merge(Node node1, Node node2) {

        Node head1 = node1;
        Node nail1 = node1.left;
        Node head2 = node2;
        Node nail2 = node2.left;

        nail1.right = head2;
        head2.left = nail1;
        head1.left = nail2;
        nail2.right = head1;
        return node1;

    }


    public static Node treeToDoublyList2(Node root) {
        if (root == null) return null;
        Stack<Node> s = new Stack<>();
        Node node = root, head = null, temp = null;
        while (true) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else if (!s.isEmpty()) {
                node = s.pop();
                temp = node;
                node = node.right;
                temp.left = temp;
                temp.right = temp;
                if (head == null) {
                    head = temp;
                }else {
                    merge(head,temp);
                }
            } else {
                break;
            }
        }
        return head;
    }
}