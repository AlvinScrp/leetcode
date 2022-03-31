import node.ListNode;

class A160 {

    public static void main(String[] args) {
        // System.out.println(new A160().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            ListNode p = headA, q = headB;
//            while ((p == null && q == null) || p == q) {
            while (p != q) {
                p = p != null ? p.next : headB;
                q = q != null ? q.next : headA;
            }
            return p;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







