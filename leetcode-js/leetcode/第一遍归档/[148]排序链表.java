import node.ListNode;

class A148 {

    public static void main(String[] args) {
        //new A148().new Solution()
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
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode tail = head;
            while (tail.next != null) tail = tail.next;

            ListNode sorted = sortList(head, tail);
            return sorted;

        }

        private ListNode sortList(ListNode head, ListNode tail) {
            if (head == null || head == tail) return head;
            ListNode dummy = new ListNode(-1, head);

            ListNode slow = dummy;
            ListNode fast = dummy;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode mid = slow;
            ListNode midNext = mid.next;
            mid.next = null;

            ListNode u = sortList(head, mid);
            ListNode v = sortList(midNext, tail);
            return mergeTwoList(u, v);
        }

        /**
         * 合并两个有序链表
         *
         * @param u
         * @param v
         * @return
         */
        private ListNode mergeTwoList(ListNode u, ListNode v) {
            if (u == null || v == null) return u != null ? u : v;
            if (u.val < v.val) {
                u.next = mergeTwoList(u.next, v);
                return u;
            } else {
                v.next = mergeTwoList(u, v.next);
                return v;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







