class A_Offer36 {

    public static void main(String[] args) {
        // System.out.println(new A剑指 Offer 36().new Solution());
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

    ;

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Node treeToDoublyList(Node root) {
            if (root == null) return null;

            Node left = treeToDoublyList(root.left);
            Node right = treeToDoublyList(root.right);
            Node node = root;
            node.left = node;
            node.right = node;

            node = connect(left, node);
            node = connect(node, right);
            return node;
        }

        public Node connect(Node p, Node q) {
            if (p == null || q == null) return p == null ? q : p;
            Node temp = q.left;
            p.left.right = q;
            q.left = p.left;
            temp.right = p;
            p.left = temp;
            return p;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







