package leetcode.p101_200;

import java.util.*;

public class P146 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));     // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));     // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));      // 返回  4

//        LRUCache cache = new LRUCache(1);
//        cache.put(2, 1);
//        System.out.println(cache.get(2));
//        cache.put(3, 2);// 返回  1
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(3));   // 返回  4

//        1,-1,-1,3,4


    }


    static class LRUCache {

        class Node {
            int key, val;
            Node pre, next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }

            @Override
            public String toString() {
                return "(" + key + "," + val + ")";
            }
        }

        Map<Integer, Node> map = new HashMap<>();
        Node head, tail;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node node = map.get(key);
            delete(node);
            addLast(node);
            return node.val;
        }


        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                delete(node);
                addLast(node);
                node.val = value;

            } else {
                if (map.size() == capacity) {
                    map.remove(head.next.key);
                    delete(head.next);
                }
                Node node = new Node(key, value);
                map.put(key, node);
                addLast(node);

            }
        }

        public void delete(Node node) {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
        }

        public void addLast(Node node) {
            Node pre = tail.pre;
            pre.next = node;
            node.pre = pre;
            node.next = tail;
            tail.pre = node;
        }

    }

}
