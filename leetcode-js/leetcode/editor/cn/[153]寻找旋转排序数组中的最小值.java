class A153 {

    public static void main(String[] args) {
        // System.out.println(new A153().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {

            int l = 0, r = nums.length - 1;
            while (l < r) {
                if (nums[l] < nums[r]) break;
                int mid = l + (r - l) / 2;
                if (nums[mid] > nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return nums[l];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







