import java.util.Stack;

class A232 {

    public static void main(String[] args) {
        // System.out.println(new A232().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {

        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            a.push(x);
        }

        public int pop() {
            reverse();
            return b.pop();
        }

        public int peek() {
            reverse();
            return b.peek();
        }

        public void reverse() {
            if (b.isEmpty()) {
                while (!a.isEmpty()) {
                    b.push(a.pop());
                }
            }
        }

        public boolean empty() {
            return b.isEmpty() && a.empty();
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







