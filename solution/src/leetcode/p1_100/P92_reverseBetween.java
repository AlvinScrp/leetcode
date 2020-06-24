package leetcode.p1_100;

public class P92_reverseBetween {
    public static void main(String[] args) {


        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
//        print(reverseBetween(l1, 1, 5)) ;
        print(reverse(l1)) ;

    }

   static ListNode  reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    public static void print(ListNode node) {
        while (node != null) {
            System.out.print("," + node.val);
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode((-1));
        dummy.next = head;
        ListNode before = dummy, before_head = dummy;
        for (int i = 0; i < m - 1; i++) {
            before = before.next;
        }

        ListNode p = before.next.next;
        ListNode l_head = new ListNode((-1));
        ListNode l_foot = before.next;
        l_head.next = l_foot;
        l_foot.next = null;

        for (int i = m + 1; i <= n && p != null; i++) {
            ListNode temp = p;
            p = p.next;
            temp.next = l_head.next;
            l_head.next = temp;

        }
        before.next = l_head.next;
        l_foot.next = p;

        return before_head.next;

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
