class A704 {

    public static void main(String[] args) {
        // System.out.println(new A704().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {

            int l = 0, r = nums.length - 1, mid;
            while (l <= r) {
                mid = l + (r - l) / 2;
                if (target == nums[mid]) return mid;
                else if (target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







