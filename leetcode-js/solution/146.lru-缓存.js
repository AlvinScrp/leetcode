/*
 * @lc app=leetcode.cn id=146 lang=javascript
 *
 * [146] LRU 缓存
 */

// @lc code=start
/**
 * @param {number} capacity
 */
var LRUCache = function (capacity) {
  this.capacity = capacity;
  this.count = 0;
  this.map = new Map();
  this.head = {};
  this.tail = {};
  this.head.next = this.tail;
  this.head.prev = this.tail;
  this.tail.next = this.head;
  this.tail.prev = this.head;
};

/**
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function (key) {
  let { map, head, remove, insertAhead } = this;
  var entry = map[key];
  if (entry && entry.prev != head) {
    remove(entry);
    insertAhead(head, entry);
  }
  return entry ? entry.value : -1;
};

LRUCache.prototype.insertAhead = function (head, entry) {
  const next = head.next;
  head.next = entry;
  entry.prev = head;
  entry.next = next;
  next.prev = entry;
};
LRUCache.prototype.remove = function (entry) {
  const next = entry.next;
  const prev = entry.prev;
  prev.next = next;
  next.prev = prev;
};

/**
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function (key, value) {
  let { map, insertAhead, remove, head, tail, capacity } = this;
  var entry = map[key];
  if (entry) {
    entry.value = value;
    if (entry.prev != head) {
      remove(entry);
      insertAhead(head, entry);
    }
  } else {
    if (this.count == capacity) {
      const entryRemoved = tail.prev;
      remove(entryRemoved);
      map[entryRemoved.key] = null;
      this.count--;
    }
    entry = { key: key, value: value };
    map[key] = entry;
    this.count++;
    insertAhead(head, entry);
  }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
// @lc code=end
var lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
console.log("lRUCache.get(1) :>> ", lRUCache.get(1), 1); // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
console.log("lRUCache.get(2) :>> ", lRUCache.get(2), -1); // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
console.log("lRUCache.get(1) :>> ", lRUCache.get(1), -1); // 返回 -1 (未找到)
console.log("lRUCache.get(3) :>> ", lRUCache.get(3), 3); // 返回 3
console.log("lRUCache.get(4) :>> ", lRUCache.get(4), 4); // 返回 4
