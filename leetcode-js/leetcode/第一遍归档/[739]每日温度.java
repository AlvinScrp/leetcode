import java.util.Deque;
import java.util.LinkedList;

class A739 {

    public static void main(String[] args) {
        // System.out.println(new A739().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> q = new LinkedList<>();
            int[] ans = new int[temperatures.length];

            for (int i = 0; i < temperatures.length; i++) {
                while (!q.isEmpty() && temperatures[q.peekLast()] < temperatures[i]) {
                    int j = q.removeLast();
                    ans[j] = i - j;
                }
                q.offer(i);
            }
            while (!q.isEmpty()) {
                ans[q.pop()] = 0;
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







