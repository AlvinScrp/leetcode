import node.ListNode;

class A142 {

    public static void main(String[] args) {
        // System.out.println(new A142().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) return null;

            ListNode p = head, q = head;
            while (q != null && q.next != null) {
                q = q.next.next;
                p = p.next;
                if (p == q) break;
            }
            if (p != q) return null;

            p = head;
            while (true) {
                if (p == q) break;
                p = p.next;
                q = q.next;
            }
            return p;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







