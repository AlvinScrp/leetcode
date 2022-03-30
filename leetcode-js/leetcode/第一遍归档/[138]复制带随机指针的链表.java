import node.Node;

class A138 {

    public static void main(String[] args) {

        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        node7.nextAndRandom(node13, null);
        node13.nextAndRandom(node11, node7);
        node11.nextAndRandom(node10, node1);
        node10.nextAndRandom(node1, node11);
        node1.nextAndRandom(null, node7);

        Node node = new A138().new Solution().copyRandomList(node7);
        System.out.println();
    }

    private static void print(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

    class Solution {
        //        public Node copyRandomList(Node head) {
//            Map<Node, Node> map = new HashMap<>();
//            for (Node node = head; node != null; node = node.next)
//                map.put(node, new Node(node.val));
//
//            for (Node node = head; node != null; node = node.next) {
//                if (node.random != null) {
//                    map.get(node).random = map.get(node.random);
//                }
//                if (node.next != null) {
//                    map.get(node).next = map.get(node.next);
//                }
//            }
//            return map.get(head);
//        }
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Node node = head, next;
            while (node != null) {
                next = node.next;
                node.next = new Node(node.val);
                node.next.next = next;
                node = next;
            }
//            print(head);
            node = head;
            while (node != null) {
                if (node.random != null) {
                    node.next.random = node.random.next;
                }
                node = node.next.next;
            }
            node = head;
            Node copy = head.next, copyHead = copy;
            while (node != null) {
                node.next = node.next.next;
                node = node.next;
                if (copy.next != null) {
                    copy.next = copy.next.next;
                    copy = copy.next;
                }

            }

            return copyHead;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}







