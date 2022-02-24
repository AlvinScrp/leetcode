package leetcode.sort;

public class P147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode node = head, temp;
        while (node != null) {
            temp = node.next;
            node.next = null;
            sort(node, dummy);
            node = temp;
        }
        return dummy.next;

    }


    //插入，并且返回最后一个节点
    private void sort(ListNode insertNode, ListNode dummy) {
        if (insertNode == dummy.next) return;

        ListNode q = dummy;
        while (q.next != null && q.next.val <= insertNode.val) q = q.next;
        insertNode.next = q.next;
        q.next = insertNode;

    }
}
