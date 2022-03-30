import node.ListNode;

class A24 {

    public static void main(String[] args) {
        // System.out.println(new A24().new Solution());
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
        public ListNode swapPairs(ListNode head) {

            ListNode dummy = new ListNode(-1, head), node = dummy;
            ListNode temp1;
            while (node.next != null && node.next.next != null) {
                temp1 = node.next;
                node.next = node.next.next;
                temp1.next = temp1.next.next;
                node.next.next = temp1;
                node = temp1;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







