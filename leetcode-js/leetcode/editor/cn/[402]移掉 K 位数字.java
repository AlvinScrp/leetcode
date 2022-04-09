import java.util.ArrayDeque;
import java.util.Deque;

class A402 {

    public static void main(String[] args) {
        System.out.println(new A402().new Solution().removeKdigits("1432219", 3));
        System.out.println(new A402().new Solution().removeKdigits("10200", 1));
        System.out.println(new A402().new Solution().removeKdigits("10", 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            if (k == num.length()) return "0";
            Deque<Character> q = new ArrayDeque<>();
            int count = 0;
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                for (; !q.isEmpty() && q.getLast() > c && count < k; count++) q.removeLast();
                q.addLast(c);
            }

            for (; count < k && !q.isEmpty(); count++) q.removeLast();
            while (!q.isEmpty() && q.getFirst() == '0') q.removeFirst();

            if (q.isEmpty()) return "0";
            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) sb.append(q.pollFirst());

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







