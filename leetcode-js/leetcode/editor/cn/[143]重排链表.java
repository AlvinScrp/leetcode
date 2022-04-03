import node.ListNode;

class A143 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        new A143().new Solution().reorderList(node);
        System.out.println();
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
            ListNode p = head, q = head;
            while (q != null && q.next != null && q.next.next != null) {
                p = p.next;
                q = q.next.next;
            }
            if (p == q) return;

            q = p.next;//q为后半节点的首节点
            p.next = null;
            p = head;

            //reverse q
            ListNode dummy = new ListNode(-1, q), node = q.next;
            while (node != null) {
                q.next = node.next;
                node.next = dummy.next;
                dummy.next = node;
                node = q.next;
            }
            q = dummy.next;


            //merge p q  and p first
            ListNode temp;
            while (p != null && q != null) {
                temp = q.next;
                q.next = p.next;
                p.next = q;
                p = p.next.next;
                q = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







