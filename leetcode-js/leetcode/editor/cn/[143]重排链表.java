import node.ListNode;

class A143 {

    public static void main(String[] args) {
        //new A143().new Solution()
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
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) return;
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode reverse = reverse(slow.next);
            slow.next = null;
            ListNode next1, next2;
            ListNode node = head;
            while (reverse != null) {
                next1 = node.next;
                next2 = reverse.next;
                node.next = reverse;
                reverse.next = next1;
                reverse = next2;
                node = next1;
            }
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode node = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







