class A162 {

    public static void main(String[] args) {
        // System.out.println(new A162().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                if (nums[mid] > nums[mid - 1]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            return l;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







