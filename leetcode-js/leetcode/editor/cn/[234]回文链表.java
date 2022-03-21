import node.ListNode;

class A234 {

    public static void main(String[] args) {
        // System.out.println(new A234().new Solution());
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

        public boolean isPalindrome(ListNode head) {
            p = head;
            return check(head);
        }

        ListNode p = null;

        private boolean check(ListNode q) {
            if (q == null) return true;
            boolean res = check(q.next) && (q.val == p.val);
            p = p.next;
            return res;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}







