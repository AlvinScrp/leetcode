import java.util.Stack;

class A_Offer_09 {

    public static void main(String[] args) {
        // System.out.println(new A剑指 Offer 09().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {
        private Stack<Integer> a = new Stack<>();
        private Stack<Integer> b = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            a.push(value);

        }

        public int deleteHead() {
            if (b.isEmpty()) {
                while (!a.isEmpty()) {
                    b.push(a.pop());
                }
            }
            return b.isEmpty() ? -1 : b.pop();

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







