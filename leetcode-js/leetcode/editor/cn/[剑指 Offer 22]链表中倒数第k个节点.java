import node.ListNode;

class AOffer22 {

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
            ListNode p = head, q = head;
            for (int i = 0; i < k; i++) {
                p = p.next;
            }
            while (p != null) {
                p = p.next;
                q = q.next;
            }
            return q;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







