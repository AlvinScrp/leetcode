import java.util.HashMap;
import java.util.Map;

class A146 {

    public static void main(String[] args) {
        // System.out.println(new A146().new Solution());

//        LRUCache cache = new LRUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // 返回  1
//        cache.put(3, 3);    // 该操作会使得关键字 2 作废
//        System.out.println(cache.get(2));     // 返回 -1 (未找到)
//        cache.put(4, 4);    // 该操作会使得关键字 1 作废
//        System.out.println(cache.get(1));     // 返回 -1 (未找到)
//        System.out.println(cache.get(3));       // 返回  3
//        System.out.println(cache.get(4));      // 返回  4
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        private Map<Integer, Entry> map = new HashMap<>();

        int capacity;
        Entry head, tail;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Entry();
            tail = new Entry();
            head.next = tail;
            tail.pre = head;

        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Entry e = map.get(key);
                remove(e);
                ahead(e);
                return e.value;
            }
            return -1;

        }

        public void put(int key, int value) {

            if (map.containsKey(key)) {
                Entry e = map.get(key);
                e.value = value;
                remove(e);
                ahead(e);
            } else {
                if (map.size() == capacity) {
                    map.remove(tail.pre.key);
                    remove(tail.pre);
                }
                Entry e = new Entry(key, value);
                map.put(key, e);
                ahead(e);
            }

        }

        private void ahead(Entry e) {
            Entry next = head.next;
            head.next = e;
            e.pre = head;
            e.next = next;
            next.pre = e;
        }

        private void remove(Entry e) {
            Entry pre = e.pre, next = e.next;
            pre.next = next;
            next.pre = pre;
            e.next = null;
            e.pre = null;
        }


        class Entry {
            int key;
            int value;
            Entry pre;
            Entry next;

            public Entry() {
            }

            public Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}







