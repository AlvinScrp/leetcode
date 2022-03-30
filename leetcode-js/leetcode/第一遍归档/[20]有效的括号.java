import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class A20 {

    public static void main(String[] args) {
        System.out.println( new A20().new Solution().isValid("){"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 == 1) return false;
            Deque<Character> stack = new ArrayDeque<>();
            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!map.containsKey(c)) {
                    stack.push(c);
                } else if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                    return false;
                }
            }
            return stack.isEmpty();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}