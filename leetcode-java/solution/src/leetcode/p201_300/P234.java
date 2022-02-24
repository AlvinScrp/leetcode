package leetcode.p201_300;

import leetcode.sort.ListNode;

public class P234 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
//        head.next.next=new ListNode(3);
//        head.next.next.next=new ListNode(3);
//        head.next.next.next.next=new ListNode(2);
//        head.next.next.next.next.next=new ListNode(1);
//        head.next.next.next.next.next.next=new ListNode(1);
        System.out.println(isPalindrome(head));
    }


    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null, next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;

        }
//        System.out.println("slow:"+slow+"    fast:"+fast);

        //奇数
        if (fast.next == null) {
            next = slow.next;
        } else {
            // 偶数
            next = slow.next;
            slow.next = pre;
            pre = slow;

        }
//        System.out.println("pre:"+pre+"    next:"+next);
        while (pre != null) {
            if (pre.val != next.val) {
                return false;
            }
            pre = pre.next;
            next = next.next;
        }

        return true;


    }


}
