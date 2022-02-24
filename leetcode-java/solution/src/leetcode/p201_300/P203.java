package leetcode.p201_300;

import leetcode.sort.ListNode;

public class P203 {

//    输入: 1->2->6->3->4->5->6, val = 6
//    输出: 1->2->3->4->5

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode node = dummy;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return dummy.next;

    }
}
