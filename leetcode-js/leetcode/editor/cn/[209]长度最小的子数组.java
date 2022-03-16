class A209 {

    public static void main(String[] args) {
        System.out.println(new A209().new Solution().minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(new A209().new Solution().minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {

            int ans = nums.length + 1;
            int sum = nums[0];
            for (int i = 0, j = 0; i <= j && j < nums.length; ) {
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    if (ans == 1) break;
                    sum -= nums[i];
                    i++;
                } else {
                    if (j == nums.length - 1) break;
                    sum += nums[++j];
                }

            }
            return ans > nums.length ? 0 : ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







