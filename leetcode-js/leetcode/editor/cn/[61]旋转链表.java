import node.ListNode;

class A61 {

    public static void main(String[] args) {
        // System.out.println(new A61().new Solution());
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
        public ListNode rotateRight(ListNode head, int k) {

            if (head == null || head.next == null || k == 0) return head;

            ListNode node = head;
            int count = 1;
            while (node.next != null) {
                count++;
                node = node.next;
            }

            int j = count - k % count;
            if (j == count) return head;
            ListNode tail = node;
            tail.next = head;
            node = head;
            for (int i = 1; i < j; i++) {
                node = node.next;
            }
            ListNode ans = node.next;
            node.next = null;
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







