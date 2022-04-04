import java.util.Deque;
import java.util.LinkedList;

class A32 {

    public static void main(String[] args) {
        System.out.println(new A32().new Solution().longestValidParentheses("(()"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {


            if (s.length() <= 1) return 0;
            int max = 0;
            s = ")" + s;
            int n = s.length();
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                        stack.pop();
                        max = Math.max(max, i - stack.peek());
                    } else {
                        stack.push(i);
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







