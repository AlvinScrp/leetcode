package node;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" + val + "}";
    }

    public String asString() {
        return val + "," + (next != null ? next.asString() : "");
    }

    public void print() {
        System.out.print(val + ",");
        if (next != null) {
            next.print();
        }
    }
}
