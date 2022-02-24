package leetcode_jianzhioffer;

import java.util.HashMap;
import java.util.Map;

public class J35 {
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
//    public Node copyRandomList(Node head) {
//        Map<Node, Node> nodeMap = new HashMap<>();
//
//        Node node = head;
//        while (node != null) {
//            nodeMap.put(node, new Node(node.val));
//            node = node.next;
//        }
//
//        for (Map.Entry<Node, Node> entry : nodeMap.entrySet()) {
//            Node key = entry.getKey();
//            Node value = entry.getValue();
//            value.next = nodeMap.get(key.next);
//            value.random = nodeMap.get(key.random);
//        }
//        return nodeMap.get(head);
//
//    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

//将拷贝节点放到原节点后面，例如1->2->3这样的链表就变成了这样1->1'->2->2'->3->3'
        Node newNode=null;
        for (Node node = head; node != null; node = node.next.next) {
            newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }
        //把拷贝节点的random指针安排上
        for (Node node = head; node != null; node = node.next.next) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
        }

        //分离拷贝节点和原节点，变成1->2->3和1'->2'->3'两个链表，后者就是答案
//        Node newHead = head.next;
//        Node temp;
//        for (Node node = head; node != null && node.next != null; ) {
//            temp = node.next;
//            node.next = temp.next;
//            node = temp;
//        }
        Node newHead = head.next;
        Node copy;
        for (Node node = head; node != null ; ) {
            copy = node.next;
            node.next = copy.next;
            node=node.next;
            if(copy.next!=null) {
                copy.next = node.next;
            }
        }

        return newHead;
    }


}