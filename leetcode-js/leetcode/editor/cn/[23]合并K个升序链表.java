import node.ListNode;

class A23 {

    public static void main(String[] args) {
        // System.out.println(new A23().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return null;
            return mergeKLists(lists, 0, lists.length - 1);
        }

        private ListNode mergeKLists(ListNode[] lists, int l, int r) {
            if (l == r) return lists[l];
            if (l + 1 == r) return mergeTwoList(lists[l], lists[r]);
            int mid = l + (r - l) / 2;
            return mergeTwoList(mergeKLists(lists, l, mid), mergeKLists(lists, mid + 1, r));
        }

        private ListNode mergeTwoList(ListNode p, ListNode q) {
            ListNode dummy = new ListNode(-1), pre = dummy;
            while (p != null && q != null) {
                if (p.val < q.val) {
                    pre.next = p;
                    p = p.next;
                } else {
                    pre.next = q;
                    q = q.next;
                }
                pre = pre.next;
            }
            pre.next = p != null ? p : q;

            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







