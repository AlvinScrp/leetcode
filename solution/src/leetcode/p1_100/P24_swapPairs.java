package leetcode.p1_100;

public class P24_swapPairs {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        ListNode res = swapPairs(l1);

        while (res != null) {
            System.out.print("," + res.val);
            res = res.next;
        }

    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        if (head.next == null) {
            return head;
        }

        ListNode x = dummy, p = head, q = head.next;

        while (true) {
            p.next = q.next;
            q.next = p;
            x.next = q;
            if (dummy.next == null) {
                dummy.next = q;
            }

            if (p.next != null && p.next.next != null) {
                ListNode tempX = p, tempP = p.next, tempQ = p.next.next;
                x = tempX;
                p = tempP;
                q = tempQ;
            } else {
                break;
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
