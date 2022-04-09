import node.ListNode;

class A83 {

    public static void main(String[] args) {
        // System.out.println(new A83().new Solution());
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

            ListNode node = head;
            while (node != null) {
                while (node.next != null && node.val == node.next.val) node.next = node.next.next;
                node = node.next;
            }
            return head;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







