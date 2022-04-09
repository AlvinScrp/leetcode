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
        ListNode pre = null;

        public boolean isPalindrome(ListNode head) {
            pre = head;
            return dfs(head);

        }

        private boolean dfs(ListNode node) {
            if (node == null) return true;
            if (!dfs(node.next)) return false;
            if (node.val != pre.val) return false;
            pre = pre.next;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







