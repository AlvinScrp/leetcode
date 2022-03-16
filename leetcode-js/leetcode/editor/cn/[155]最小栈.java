import java.util.Stack;

class A155 {

    public static void main(String[] args) {
        // System.out.println(new A155().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        Stack<Integer> s = new Stack<>();
        Stack<Integer> minS = new Stack<>();


        public MinStack() {

        }

        public void push(int val) {
            s.push(val);
            minS.push(minS.isEmpty() ? val : Math.min(minS.peek(), val));

        }

        public void pop() {
            if (s.isEmpty()) return;
            s.pop();
            minS.pop();

        }

        public int top() {
            if (s.isEmpty()) return -1;
            return s.peek();

        }

        public int getMin() {
            if (minS.isEmpty()) return -1;
            return minS.peek();

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







