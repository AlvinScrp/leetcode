import java.util.Arrays;


class A16 {

    public static void main(String[] args) {
        // System.out.println(new A16().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int ans = nums[0] + nums[1] + nums[2];
            for (int k = 1; k < nums.length - 1; k++) {
                int i = 0, j = nums.length - 1;
                while (i < k && k < j) {
                    int sum = nums[i] + nums[k] + nums[j];
                    if (sum == target) return target;
                    ans = Math.abs(target - sum) < Math.abs(target - ans) ? sum : ans;
                    if (sum > target) j--;
                    else if (sum < target) i++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







