import node.ListNode;

class A19 {

    public static void main(String[] args) {
        // System.out.println(new A19().new Solution());
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
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode dummy = new ListNode(-1, head);
            ListNode p = head, q = dummy;
            for (int i = 1; i <= n; i++) {
                p = p.next;
            }
            while (p != null) {
                p = p.next;
                q = q.next;
            }
            q.next = q.next.next;
            return dummy.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







