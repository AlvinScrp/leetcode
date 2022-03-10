import node.ListNode;

class A92 {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = new A92().new Solution().reverseBetween(node1, 2, 4);
        while (node != null) {
            System.out.print(node.val);
            System.out.print(",");
            node = node.next;
        }
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == right) return head;

            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode start = null;
            ListNode node = head;
            ListNode pre = dummy;
            ListNode next = null;
            int count = 1;
            while (node != null) {
                if (count == left) {
                    start = node;
                    pre.next = null;
                } else if (count == right) {
                    next = node.next;
                    node.next = null;
                    pre.next = reverse(start);
                    start.next = next;
                    break;
                }
                count++;
                if (start == null) pre = node;
                node = node.next;
            }
            return dummy.next;
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode node = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}