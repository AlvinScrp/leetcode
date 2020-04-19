package leetcode;

public class P23_mergeKLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(l1, l2);

        while (result != null) {
            System.out.print("," + result.val);
            result = result.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        ListNode l = mergeKLists(lists, lists.length - 1);
        return l;
    }

    public ListNode mergeKLists(ListNode[] lists, int end) {
        int i = 0, j = end;
        while (i < j) {
            lists[i] = mergeTwoLists(lists[i], lists[j]);
            i++;
            j--;
        }

        if (j == 0) {
            return lists[0];
        } else {
            return mergeKLists(lists, j);
        }
    }

    /**
     * Definition for singly-linked list.
     */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode source = res;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
                res = res.next;
            } else if (l1.val <= l2.val) {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
                res = res.next;
            }
        }
        res.next = l1 != null ? l1 : l2;
        return source.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}