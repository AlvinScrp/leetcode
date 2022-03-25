import java.util.Stack;

class A1190 {

    public static void main(String[] args) {
        System.out.println(new A1190().new Solution().reverseParentheses("a(u(love)i)b"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //         "a(u(love)i)b"
        public String reverseParentheses(String s) {
            Stack<String> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(sb.toString());
                    sb.setLength(0);
                } else if (c == ')') {
                    sb.reverse();
                    sb.insert(0, stack.pop());
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







