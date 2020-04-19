package leetcode;

public class P82_deleteDuplicates {

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(3);
//        l1.next.next.next.next = new ListNode(4);
//        l1.next.next.next.next.next = new ListNode(4);
//        l1.next.next.next.next.next.next = new ListNode(5);
//        ListNode res = deleteDuplicates(l1);


        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(3);
        ListNode res = deleteDuplicates(l1);

        while (res != null) {
            System.out.print("," + res.val);
            res = res.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = dummy;
        ListNode dp = head;
        ListNode dq = head.next;

        while (true) {
            if (dp.val == dq.val) {
                if (dq.next != null) {
                    dq = dq.next;
                } else {
                    start.next = null;
                    break;
                }
            } else {
                if (dp.next == dq) {
                    start = dp;
                    dp = dq;
                    dq = dq.next;
                } else {
                    start.next = dq;
                    dp = dq;
                    dq = dq.next;
                }
                if (dq == null) {
                    break;
                }
            }
        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "(" + val + ")";
        }
    }
}
