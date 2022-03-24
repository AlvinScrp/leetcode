class A34 {

    public static void main(String[] args) {
        // System.out.println(new A34().new Solution());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0
                    || target < nums[0]
                    || target > nums[nums.length - 1]) {
                return new int[]{-1, -1};
            }
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (target <= nums[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (nums[l] != target) {
                return new int[]{-1, -1};
            }
            int begin = l;
            r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2 + 1;
                if (target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            int end = nums[l] != target ? l - 1 : l;
            return new int[]{begin, end};


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







