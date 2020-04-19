package leetcode;

public class P21_mergeTwoLists {
//    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);
//
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
//
//        ListNode result = mergeTwoLists(l1, l2);
//
//        while (result != null) {
//            System.out.print("," + result.val);
//            result = result.next;
//        }
//    }
//
//    /**
//     * Definition for singly-linked list.
//     */
//
//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode res = new ListNode(-1);
//        ListNode source = res;
//
//        while (l1 != null && l2 != null) {
//            if (l1.val > l2.val) {
//                res.next = new ListNode(l2.val);
//                l2 = l2.next;
//                res = res.next;
//            } else if (l1.val <= l2.val) {
//                res.next = new ListNode(l1.val);
//                l1 = l1.next;
//                res = res.next;
//            }
//        }
//        res.next = l1 != null ? l1 : l2;
//        return source.next;
//    }
//
//    static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
}