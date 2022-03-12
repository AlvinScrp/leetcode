import node.ListNode;

class A142 {

    public static void main(String[] args) {
        // System.out.println(new A142().new Solution());
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
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while (true) {
                if (fast == null || fast.next == null) return null;
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    while (head != slow) {
                        head = head.next;
                        slow = slow.next;
                    }
                    return slow;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







