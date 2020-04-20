package leetcode;

public class P86_partition {


    public static void main(String[] args) {


        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(2);
        ListNode res = partition(l1, 3);


//        ListNode l1 = new ListNode(3);
//        l1.next = new ListNode(1);
//        l1.next.next = new ListNode(2);
//        ListNode res = partition(l1, 3);


        while (res != null) {
            System.out.print("," + res.val);
            res = res.next;
        }
    }

    //3->1->2  3
//    public static ListNode partition(ListNode head, int x) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode dummy = new ListNode((-1));
//        dummy.next = head;
//
//
//        ListNode q = dummy;
//        ListNode temp = new ListNode((-1));
//        ListNode p = temp;
//        while (q.next != null) {
//            if (q.next.val >= x) {
//                p.next = q.next;
//                q.next = q.next.next;
//                p = p.next;
//                p.next = null;
//            } else {
//                q = q.next;
//            }
//
//        }
//        q.next = temp.next;
//        return dummy.next;
//
//    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = new ListNode((-1));
        ListNode q = new ListNode((-1));
        ListNode start = head;
        ListNode qStart = q;
        ListNode pStart = p;

        while (start != null) {
            if (start.val >= x) {
                q.next = start;
                start = start.next;
                q = q.next;
                q.next = null;
            } else {
                p.next = start;
                start = start.next;
                p = p.next;
                p.next = null;
            }
        }
        p.next = qStart.next;
        return pStart.next;

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
