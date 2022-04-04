import java.util.Stack;

class A232 {

    public static void main(String[] args) {
        // System.out.println(new A232().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {

        Stack<Integer> p = new Stack<>();
        Stack<Integer> q = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            p.push(x);

        }

        public int pop() {
            fillQIfEmpty();
            return q.isEmpty() ? -1 : q.pop();

        }


        public int peek() {
            fillQIfEmpty();
            return q.isEmpty() ? -1 : q.peek();
        }

        private void fillQIfEmpty() {
            if (q.isEmpty()) {
                while (!p.isEmpty()) {
                    q.push(p.pop());
                }
            }
        }

        public boolean empty() {
            return p.isEmpty() && q.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}







