import java.util.Arrays;

class A135 {

    public static void main(String[] args) {
        // System.out.println(new A135().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int candy(int[] ratings) {
            int[] nums = new int[ratings.length];
            Arrays.fill(nums, 1);
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    nums[i] = nums[i - 1] + 1;
                }
            }
            for (int i = ratings.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    nums[i] = Math.max(nums[i + 1] + 1, nums[i]);
                }
            }
            int ans = 0;
            for (int num : nums) {
                ans += num;
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







