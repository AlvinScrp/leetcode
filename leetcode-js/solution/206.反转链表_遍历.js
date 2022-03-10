/*
 * @lc app=leetcode.cn id=206 lang=javascript
 *
 * [206] 反转链表
 */

function ListNode(val, next) {
  //   let node = {};
  this.val = val === undefined ? 0 : val;
  this.next = next === undefined ? null : next;
  //   return node;
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
  let dummy = new ListNode();
  let node = head;
  while (node) {
    var temp = node.next;
    node.next = dummy.next;
    dummy.next = node;
    node = temp;
  }
  node = dummy.next;
  dummy.next == null;
  return node;
};
// @lc code=end
let sd = "sdsd";
let node5 = new ListNode(5);
let node4 = new ListNode(4, node5);
let node3 = new ListNode(3, node4);
let node2 = new ListNode(2, node3);
let node1 = new ListNode(1, node2);
let node = reverseList(node1);
while (node) {
  console.log(node.val);
  node = node.next;
}
