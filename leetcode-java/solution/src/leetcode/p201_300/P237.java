package leetcode.p201_300;

import leetcode.sort.ListNode;

public class P237 {

    public void deleteNode(ListNode node) {

        node.val=node.next.val;
        node.next=node.next.next;
//        while (true) {
//            node.val = node.next.val;
//            if (node.next.next == null) {
//                node.next = null;
//                break;
//            }
//            node = node.next;
//
//        }


    }
}
