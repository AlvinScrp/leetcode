import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class A56 {

    public static void main(String[] args) {
        // System.out.println(new A56().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            Stack<int[]> s = new Stack<>();
            for (int[] q : intervals) {
                if (!s.isEmpty() && s.peek()[1] >= q[0]) {
                    int[] p = s.peek();
                    p[1] = Math.max(p[1], q[1]);
                } else {
                    s.push(q);
                }
            }

            int[][] ans = new int[s.size()][2];
            int j = s.size() - 1;
            while (!s.isEmpty()) {
                ans[j--] = s.pop();
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







