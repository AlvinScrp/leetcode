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
            ListNode dummy = new ListNode(-1);
            dummy.next = add(l1, l2, 0);
            return dummy.next;
        }

        private ListNode add(ListNode l1, ListNode l2, int carry) {
            if (l1 == null && l2 == null) {
                return carry == 1 ? new ListNode(1) : null;
            }
            int value = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            ListNode node = new ListNode(value % 10);
            int newCarry = value >= 10 ? 1 : 0;
            node.next = add(l1 == null ? null : l1.next, l2 == null ? null : l2.next, newCarry);
            return node;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







