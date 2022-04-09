import node.ListNode;

class A24 {

    public static void main(String[] args) {
        // System.out.println(new A24().new Solution());
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
        public ListNode swapPairs(ListNode head) {

            ListNode dummy = new ListNode(-1, head);
            ListNode p = dummy, q = head;

            while (q != null && q.next != null) {
                p.next = q.next;
                q.next = p.next.next;
                p.next.next = q;
                p = q;
                q = q.next;
            }
            return dummy.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







