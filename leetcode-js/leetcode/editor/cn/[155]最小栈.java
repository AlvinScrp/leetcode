import java.util.Stack;

class A155 {

    public static void main(String[] args) {
        // System.out.println(new A155().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        Stack<Integer> s = new Stack<>();
        Stack<Integer> min = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            s.push(val);
            if (min.isEmpty()) {
                min.push(val);
            } else {
                min.push(Math.min(val, min.peek()));
            }

        }

        public void pop() {
            if (!s.isEmpty()) {
                s.pop();
                min.pop();
            }

        }

        public int top() {
            return s.isEmpty() ? -1 : s.peek();

        }

        public int getMin() {
            return min.isEmpty() ? -1 : min.peek();

        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}







