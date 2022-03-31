import node.ListNode;

class A206 {

    public static void main(String[] args) {
        // System.out.println(new A206().new Solution());
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
        public ListNode reverseList(ListNode head) {
            if (head == null) return null;

            ListNode dummy = new ListNode(-1, head);
            for (ListNode node = head.next; node != null; ) {
                head.next = node.next;
                node.next = dummy.next;
                dummy.next = node;
                node = head.next;
            }
            return dummy.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







