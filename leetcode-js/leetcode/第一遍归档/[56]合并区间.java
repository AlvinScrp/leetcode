import java.util.Arrays;
import java.util.Comparator;

class A56 {

    public static void main(String[] args) {
        //new A56().new Solution()
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length <= 1) return intervals;
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            int[][] res = new int[intervals.length][2];
            int index = -1;
            for (int i = 0; i < intervals.length; i++) {
                int[] next = intervals[i];
                if (index == -1 || res[index][1] < next[0]) {
                    res[++index] = next;
                } else {
                    res[index][1] = Math.max(res[index][1], next[1]);
                }
            }
            return Arrays.copyOfRange(res, 0, index + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







