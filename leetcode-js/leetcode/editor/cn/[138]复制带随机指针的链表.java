import node.Node;

class A138 {

    public static void main(String[] args) {
        // System.out.println(new A138().new Solution());
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
        public Node copyRandomList(Node head) {
            if (head == null) return null;


            Node node = head;
            while (node != null) {
                Node newNode = new Node(node.val);
                newNode.next = node.next;
                node.next = newNode;
                node = newNode.next;
            }
            node = head;
            while (node != null) {
                if (node.random != null) {
                    node.next.random = node.random.next;
                }
                node = node.next.next;
            }

            node = head;
            Node copyHead = head.next, copy = head.next;
            while (node != null) {
                node.next = copy.next;
                if (copy.next != null) {
                    copy.next = copy.next.next;
                }
                node = node.next;
                copy = copy.next;
            }


            return copyHead;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







