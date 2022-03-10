/*
 * @lc app=leetcode.cn id=206 lang=javascript
 *
 * [206] 反转链表
 */


function ListNode(val, next) {
    let node = {};
    node.val = (val === undefined ? 0 : val)
    node.next = (next === undefined ? null : next)
    return node
}

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function (head) {
    if (head == null) return null
    if (head.next === null) return head
    let node = reverseList(head.next)
    head.next.next = head
    head.next = null
    return node;
};
// @lc code=end
let sd = "sdsd"
let node5 = ListNode(5)
let node4 = ListNode(4, node5)
let node3 = ListNode(3, node4)
let node2 = ListNode(2, node3)
let node1 = ListNode(1, node2)
let node = reverseList(node1)
while (node) {
    console.log(node.val)
    node = node.next
}


