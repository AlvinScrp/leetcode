/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

import node.ListNode;

class A206 {

    public static void main(String[] args) {

    }

// @lc code=start

    /**
     * Definition for singly-linked list.
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode dummy = new ListNode(-1);
            ListNode node = head;
            ListNode temp = null;
            while (node != null) {
                temp = node.next;
                node.next = dummy.next;
                dummy.next = node;
                node = temp;
            }
            return dummy.next;
        }
    }
// @lc code=end

}

