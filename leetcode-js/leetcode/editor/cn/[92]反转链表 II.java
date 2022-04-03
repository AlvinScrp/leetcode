import node.ListNode;

class A92 {

    public static void main(String[] args) {
        // System.out.println(new A92().new Solution());
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
            if (head == null) return null;

            ListNode dummy = new ListNode(-1, head);
            ListNode pre = dummy, node = head, first = node;
            for (int i = 1; i <= right; i++) {
                if (i < left) {
                    pre = pre.next;
                    node = node.next;
                } else if (i == left) {
                    first = node;
                    node = node.next;
                } else {
                    first.next = node.next;
                    node.next = pre.next;
                    pre.next = node;
                    node = first.next;
                }

            }
            return dummy.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







