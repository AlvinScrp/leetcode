import node.ListNode;

class A148 {

    public static void main(String[] args) {
        // System.out.println(new A148().new Solution());
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
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode p = head, q = head;
            while (q != null && q.next != null && q.next.next != null) {
                q = q.next.next;
                p = p.next;
            }
            q = p.next;
            p.next = null;
            q = sortList(q);
            p = sortList(head);
            return merge(p, q);

        }

        private ListNode merge(ListNode p, ListNode q) {
            if (p == null || q == null) return p != null ? p : q;
            if (p.val < q.val) {
                p.next = merge(p.next, q);
                return p;
            } else {
                q.next = merge(p, q.next);
                return q;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







