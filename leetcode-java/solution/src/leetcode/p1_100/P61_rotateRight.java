package leetcode.p1_100;

public class P61_rotateRight {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode res = rotateRight(l1, 2);

//        ListNode l1 = new ListNode(0);
//        l1.next = new ListNode(1);
//        l1.next.next = new ListNode(2);
//
//        ListNode res = rotateRight(l1, 4);
        while (res != null) {
            System.out.print("," + res.val);
            res = res.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = head;
        ListNode res;
        int count = 1;
        while (start.next != null) {
            start = start.next;
            count++;
        }
        start.next = head;
        k = k % count;
        k = count - k;
        for (int i = 0; i < k; i++) {
            start = start.next;
        }
        res = start.next;
        start.next = null;
        return res;
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
