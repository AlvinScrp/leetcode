package leetcode.p101_200;

import leetcode_jianzhioffer.J06;

public class P141 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {

        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
    }
}
