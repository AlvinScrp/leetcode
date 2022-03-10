import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class A46 {

    public static void main(String[] args) {
        List<List<Integer>> res = new A46().new Solution().permute(new int[]{1, 2, 3});
        for (List<Integer> nums : res) {
            System.out.println(nums.toString());
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Deque<Integer> p = new ArrayDeque<>();
            boolean flags[] = new boolean[nums.length];
            backTrack(nums, nums.length, flags, p, res);
            return res;

        }

        private void backTrack(int[] nums, int remaining, boolean[] flags, Deque<Integer> p, List<List<Integer>> res) {
            if (remaining == 0) {
                res.add(new ArrayList<>(p));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (!flags[i]) {
                    p.add(nums[i]);
                    flags[i] = true;
                    backTrack(nums, remaining - 1, flags, p, res);
                    p.removeLast();
                    flags[i] = false;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}