import node.ListNode;

class A_Offer_22 {

    public static void main(String[] args) {
        // System.out.println(new A剑指 Offer 22().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode dummy = new ListNode(-1, head);
            ListNode p = dummy, q = dummy;
            int i = 0;
            while (q != null && i <= k) {
                q = q.next;
                i++;
            }
            while (q != null) {
                q = q.next;
                p = p.next;
            }
            return p.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







