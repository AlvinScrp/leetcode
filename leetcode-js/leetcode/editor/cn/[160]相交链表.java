import node.ListNode;

class A160 {

    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p = headA, q = headB;
            while (p != q) {
                p = p != null ? p.next : headB;
                q = q != null ? q.next : headA;
            }
            return p;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}