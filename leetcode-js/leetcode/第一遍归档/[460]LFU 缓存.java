import java.util.HashMap;
import java.util.Map;

class A460 {

    public static void main(String[] args) {
        // System.out.println(new A460().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {
        int size;
        int capacity;
        int minFreq;
        Map<Integer, Node> entryMap;
        Map<Integer, Link> freqMap;


        public LFUCache(int capacity) {
            size = 0;
            minFreq = 1;
            this.capacity = capacity;
            entryMap = new HashMap<>();
            freqMap = new HashMap<>();
        }

        public int get(int key) {
            if (capacity == 0) return -1;
            if (!entryMap.containsKey(key)) return -1;
            Node e = entryMap.get(key);
            removeNode(e);
            int freq = e.freq;
            e.freq = freq + 1;
            addNode(e);

            return e.value;
        }

        private void addNode(Node e) {
            entryMap.put(e.key, e);
            int freq = e.freq;
            if (!freqMap.containsKey(freq)) {
                freqMap.put(freq, new Link());
            }
            freqMap.get(freq).addEntry(e);
        }

        private void removeNode(Node e) {
            entryMap.remove(e.key);
            int freq = e.freq;
            if (freqMap.containsKey(freq)) {
                Link link = freqMap.get(freq);
                link.removeEntry(e);
                if (link.isEmpty() && freq == minFreq) {
                    freqMap.remove(freq);
                    minFreq++;
                }
            }
        }

        public void put(int key, int value) {
            if (capacity == 0) return;
            Node e = new Node(key, value);
            Node old = entryMap.get(key);
            if (old == null) {
                evictIfFull();
                addNode(e);
                minFreq = 1;
            } else {
                removeNode(old);
                e.freq += old.freq;
                addNode(e);
            }
        }

        private void evictIfFull() {
            if (entryMap.size() == capacity) {
                Link link = freqMap.get(minFreq);
                if (link != null) {
                    removeNode(link.getLast());
                }
            }
        }


        class Node {
            int key;
            int value;
            int freq = 1;
            Node pre;
            Node next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        class Link {
            //            Map<Integer, Node> map;
            Node head;
            Node tail;/**/
            int size = 0;

            public Link() {
//                map = new HashMap<>();
                head = new Node();
                tail = new Node();
                head.next = tail;
                head.pre = tail;
                tail.next = head;
                tail.pre = head;
            }

            public void addEntry(Node e) {
//                map.put(e.key, e);
                Node next = head.next;
                head.next = e;
                e.pre = head;
                next.pre = e;
                e.next = next;
                size++;
            }

            public void removeEntry(Node e) {
//                map.remove(e.key);
                Node pre = e.pre;
                Node next = e.next;
                pre.next = next;
                next.pre = pre;
                size--;

            }

            public Node getLast() {
                if (size == 0) return null;
                return tail.pre;
            }

            public boolean isEmpty() {
                return size == 0;
            }
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}







