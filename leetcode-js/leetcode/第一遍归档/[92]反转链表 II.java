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
            ListNode dummy = new ListNode(-1, head);
            ListNode pre = dummy, first = head;
            ListNode node = dummy;
            for (int index = 0; node != null && index <= right; index++) {
                if (index < left) {
                    pre = node;
                    node = node.next;
                } else if (index == left) {
                    first = node;
                    node = node.next;
                } else if (index <= right) {
                    first.next = node.next;
                    ListNode next = pre.next;
                    pre.next = node;
                    node.next = next;
                    node = first.next;
                }
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}