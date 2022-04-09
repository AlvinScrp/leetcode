import java.util.Stack;

class A_Offer_09 {

    public static void main(String[] args) {
        // System.out.println(new A剑指 Offer 09().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {
        Stack<Integer> p = new Stack<>();
        Stack<Integer> q = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            p.push(value);

        }

        public int deleteHead() {
            if (q.isEmpty()) {
                while (!p.isEmpty()) {
                    q.push(p.pop());
                }
            }
            return q.isEmpty() ? -1 : q.pop();

        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}







