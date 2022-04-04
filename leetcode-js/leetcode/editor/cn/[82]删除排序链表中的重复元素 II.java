import node.ListNode;

class A82 {

    public static void main(String[] args) {
        // System.out.println(new A82().new Solution());
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
        public ListNode deleteDuplicates(ListNode head) {

            ListNode dummy = new ListNode(-1, head);
            ListNode pre = dummy, node = head, dupFirst = null;
            while (node != null) {
                if (node.next != null && node.val == node.next.val) {
                    int dup = node.val;
                    while (node != null && node.val == dup) node = node.next;
                    pre.next = node;
                } else {
                    pre = pre.next;
                    node = node.next;
                }
            }
            return dummy.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







