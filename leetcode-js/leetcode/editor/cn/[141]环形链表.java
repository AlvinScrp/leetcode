import node.ListNode;

class A141 {

    public static void main(String[] args) {
        // System.out.println(new A141().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {

            if (head == null) return false;
            ListNode p = head, q = head;
            while (p != null && p.next != null) {
                p = p.next.next;
                q = q.next;
                if (p == q) return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







