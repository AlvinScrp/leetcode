import node.ListNode;

class A2 {

    public static void main(String[] args) {
        // System.out.println(new A2().new Solution());
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return add(l1, l2, 0);
        }

        public ListNode add(ListNode p, ListNode q, int carry) {
            if (p == null && q == null) return carry > 0 ? new ListNode(carry) : null;
            int value = (p != null ? p.val : 0) + (q != null ? q.val : 0) + carry;
            ListNode node = new ListNode(value % 10);
            node.next = add(p != null ? p.next : null, q != null ? q.next : null, value / 10);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







