import node.ListNode;

class A23 {

    public static void main(String[] args) {
        //new A23().new Solution()
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

        private ListNode mergeKLists(ListNode[] lists, int lo, int hi) {
            if (lo == hi) return lists[lo];
            int mid = lo + (hi - lo) / 2;
            return mergeTwoList(mergeKLists(lists, lo, mid), mergeKLists(lists, mid + 1, hi));
        }

        private ListNode mergeTwoList(ListNode list1, ListNode list2) {
            if (list1 == null || list2 == null) return list1 != null ? list1 : list2;
            if (list1.val < list2.val) {
                list1.next = mergeTwoList(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoList(list1, list2.next);
                return list2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}