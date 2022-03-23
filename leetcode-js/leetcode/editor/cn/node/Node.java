package node;

public class Node {
    public int val;
    public Node next;
    public Node random;

    public void nextAndRandom(Node next, Node random) {
        this.next = next;
        this.random = random;
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}
