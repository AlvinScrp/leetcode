package leetcode.p1_100;

public class P2_AddTwoNumbers {


    public static void main(String[] args) {


    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode first = result;
        while (true) {
            int value = l1.val + l2.val;
            result.val = value;
            if (l1.next == null && l2.next != null) {
                result.next = l2.next;
                break;
            } else if (l1.next != null && l2.next == null) {
                result.next = l1.next;
                break;
            } else if (l1.next != null && l2.next != null) {
                result.next = new ListNode(0);
                l1 = l1.next;
                l2 = l2.next;
                result = result.next;
            } else {
                result.val = value;
                break;
            }
        }
        ListNode start = first;
        while (true) {
            if (first.val >= 10) {
                first.val = first.val % 10;
                if (first.next == null) {
                    first.next = new ListNode(0);
                }
                first.next.val++;
            }
            first = first.next;
            if (first == null) {
                break;
            }
        }

        return start;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }


    }

}

