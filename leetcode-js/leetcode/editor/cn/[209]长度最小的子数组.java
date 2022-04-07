class A209 {

    public static void main(String[] args) {
        // System.out.println(new A209().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int ans = nums.length + 1;
            int sum = 0;

            for (int i = 0, j = 0; j < nums.length; ) {
                sum += nums[j];
                while (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    sum -= nums[i++];
                }
                j++;
            }
            return ans > nums.length ? 0 : ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







