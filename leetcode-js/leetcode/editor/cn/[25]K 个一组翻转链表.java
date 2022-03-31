import node.ListNode;

class A25 {

    public static void main(String[] args) {
        // System.out.println(new A25().new Solution());
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
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k <= 1) return head;

            int L = 0;
            for (ListNode node = head; node != null; node = node.next) L++;
            L = L - L % k;
            ListNode dummy = new ListNode(-1, head);

            ListNode pre = dummy, tail = null, node = head;
            for (int i = 1; i <= L; i++) {
                if (i % k == 1) {
                    tail = node;
                    node = node.next;
                } else {
                    tail.next = node.next;
                    node.next = pre.next;
                    pre.next = node;
                    node = tail.next;

                    if (i % k == 0) {
                        pre = tail;
                    }
                }
            }
            return dummy.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







