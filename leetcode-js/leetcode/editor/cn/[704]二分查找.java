class A704 {

    public static void main(String[] args) {
        // System.out.println(new A704().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] >= target) r = mid;
                else l = mid + 1;
            }
            return nums[l] == target ? l : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







