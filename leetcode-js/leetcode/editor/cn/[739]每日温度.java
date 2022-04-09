import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class A739 {

    public static void main(String[] args) {
        // System.out.println(new A739().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
//            if (n == 1) return new int[]{0};
            Deque<Integer> s = new LinkedList<>();
            Stack<Integer> sd = new Stack<>();
            int[] ans = new int[n];

            for (int i = 0, j; i < n; i++) {
                while (!s.isEmpty() && temperatures[s.peekLast()] < temperatures[i]) {
                    j = s.removeLast();
                    ans[j] = i - j;
                }
                s.addLast(i);
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







