import java.util.Arrays;
import java.util.Comparator;

class A452 {

    public static void main(String[] args) {
        // System.out.println(new A452().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

            int ans = 1;
            int right = points[0][1];
            for (int[] point : points) {
                if (point[0] > right) {
                    ans++;
                    right = point[1];
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







