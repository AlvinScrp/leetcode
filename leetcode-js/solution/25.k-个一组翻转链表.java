/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

import node.ListNode;

class A25 {


    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
//        printNode(node1);
        printNode(new A25().new Solution().reverseKGroup(node1, 2));
//        printNode(new A25().new Solution().reverse(node1));


    }

    static void printNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    // @lc code=start
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k <= 1) return head;
            ListNode node = head;
            ListNode dummy = new ListNode(-1);
            ListNode pre = dummy, next = null, header = null, tail = null;
            for (int i = 1; i <= k && node != null; i++) {
                if (i == 1) {
                    header = node;
                    node = node.next;
                } else if (i == k) {
                    tail = node;
                    next = tail.next;
                    tail.next = null;
                    pre.next = null;
                    reverse(header);
                    pre.next = tail;
                    header.next = next;
                    pre = header;
                    i = 0;
                    node = pre.next;
                } else {
                    node = node.next;
                }
            }
            return dummy.next;

        }

        public ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode node = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return node;
        }
    }
// @lc code=end
}

