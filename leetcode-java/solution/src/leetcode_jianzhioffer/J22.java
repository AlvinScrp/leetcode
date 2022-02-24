package leetcode_jianzhioffer;

import java.util.Stack;

public class J22 {

//    输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
//
//             
//
//    示例：
//
//    给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//    返回链表 4->5.

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //    public ListNode getKthFromEnd(ListNode head, int k) {
//
//        Stack<ListNode> stack = new Stack<>();
//        ListNode node = head;
//        while (node != null) {
//            stack.add(node);
//            node = node.next;
//        }
//
//        ListNode res = null;
//        while (!stack.isEmpty() && k > 0) {
//            stack.pop();
//            k--;
//        }
//        return res;
//    }
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode p = head;
        ListNode q = head;
        for (int i = 1; i < k && q != null; i++) {
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }

        return p;
    }
}
