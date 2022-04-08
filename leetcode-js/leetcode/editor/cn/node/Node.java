package node;

import java.util.List;

public class Node {
    public int val;
    public Node next;
    public Node random;

    public List<Node> children;

    public void nextAndRandom(Node next, Node random) {
        this.next = next;
        this.random = random;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}
