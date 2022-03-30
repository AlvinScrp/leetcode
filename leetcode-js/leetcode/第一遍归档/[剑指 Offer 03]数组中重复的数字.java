class A_Offer_03 {

    public static void main(String[] args) {
        //new A_Offer_03().new Solution()
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatNumber(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == i) continue;
                if (nums[i] == nums[nums[i]]) return nums[i];
                swap(nums, i, nums[i]);
                i--;
            }
            return -1;

        }

        private void swap(int[] nums, int i, int j) {
            int swap = nums[i];
            nums[i] = nums[j];
            nums[j] = swap;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







