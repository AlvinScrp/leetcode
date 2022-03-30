import java.util.Deque;
import java.util.LinkedList;

class A224 {

    public static void main(String[] args) {
        System.out.println(new A224().new Solution().calculate("1-(-2)"));
//        System.out.println(new A224().new Solution().calculate("1 + 1"));
//        System.out.println(new A224().new Solution().calculate("2-1 + 2 "));
//        System.out.println(new A224().new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            Deque<Character> ops = new LinkedList<>();
            Deque<Integer> nums = new LinkedList<>();
//            nums.addFirst(0);
            s = s.replace(" ", "");
            if (s.charAt(0) == '-') nums.addLast(0);
            for (int i = 0; i < s.length(); ) {
                char c = s.charAt(i);
                if (c == '(') {
                    ops.addLast(c);
                    i++;
                } else if (c == ')') {
                    while (!ops.isEmpty() && ops.peekLast() != '(') cal(ops, nums);
                    if (!ops.isEmpty() && ops.peekLast() == '(') ops.pollLast();
                    i++;
                } else if (c == '+' || c == '-') {
                    if (i > 0) {
                        char pre = s.charAt(i - 1);
                        if (pre == '(') {
                            nums.addLast(0);
                        }
                    }
                    while (!ops.isEmpty() && ops.peekLast() != '(') cal(ops, nums);
                    ops.addLast(c);
                    i++;
                } else {
                    int num = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + (s.charAt(i) - '0');
                        i++;
                    }
                    nums.addLast(num);
                }
            }
            while (!ops.isEmpty()) cal(ops, nums);
            return nums.pollLast();

        }

        private void cal(Deque<Character> ops, Deque<Integer> nums) {
            if (nums.size() < 2 || ops.isEmpty()) return;
            int b = nums.pollLast(), a = nums.pollLast();
            char op = ops.pollLast();
            nums.addLast(op == '+' ? (a + b) : (a - b));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







