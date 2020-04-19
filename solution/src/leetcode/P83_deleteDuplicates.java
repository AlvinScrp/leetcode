package leetcode;

public class P83_deleteDuplicates {

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
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
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
        ListNode start = head;
        while (start.next != null) {
            if (start.val == start.next.val) {
                start.next = start.next.next;
            }else {
                start=start.next;
            }
        }
        return head;
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
