import java.util.ArrayDeque;
import java.util.Deque;

class A239 {

    public static void main(String[] args) {
        int[] ans = new A239().new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

        for (int an : ans) {
            System.out.print(an + ", ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] ans = new int[nums.length - k + 1];
            Deque<Integer> s = new ArrayDeque<>();
            for (int i = 0; i < nums.length; i++) {
                while (!s.isEmpty() && nums[s.peekLast()] < nums[i]) s.removeLast();
                s.addLast(i);
                while (!s.isEmpty() && i - s.getFirst() + 1 > k) s.removeFirst();

                if (i + 1 >= k) {
                    ans[i + 1 - k] = nums[s.getFirst()];
                }

            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







